package T200_299;
import java.util.*;

public class T269 {
	public String alienOrder(String[] words) {
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new HashSet<Integer>());
        }
        int[] degree = new int[26];
        Arrays.fill(degree, -1);

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                if (degree[c - 'a'] < 0) {
                    degree[c - 'a'] = 0;
                }
            }
            if (i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; j++) {
                    int c1 = w1.charAt(j) - 'a', c2 = w2.charAt(j) - 'a';
                    if (c1 != c2) {
                        if (!adj.get(c1).contains(c2)) {
                            adj.get(c1).add(c2);
                            degree[c2]++;
                        }
                        break;
                    }
                    if (j == w2.length() - 1 && w1.length() > w2.length()) { // "abcd" -> "ab"
                        return "";
                    }
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                q.add(i);       
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int i = q.poll();
            sb.append((char) ('a'  + i));
            for (int j : adj.get(i)) {
                degree[j]--;
                if (degree[j] == 0) {
                    q.add(j);        
                }
            }
        }

        for (int d : degree) {
            if (d > 0) {
                return "";
            }
        }

        return sb.toString();
    }
}
