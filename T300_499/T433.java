package T300_499;

import java.util.*;

public class T433 {
	public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) {
            return -1;
        }
        if (start.equals(end)) {
            return 0;
        }
        
        HashSet<String> set = new HashSet<>(); // to quick check whether a sequence exists
        set.add(start);
        
        for (String s : bank) {                 // dictionary to set...
            set.add(s);
        }
        
        int dist = 0;
        char[] dict = new char[]{'A', 'C', 'G', 'T'};
        HashSet<String> visited = new HashSet<>(); // to store visited sequence
        
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);
        
        while (!q.isEmpty()) {
            int size = q.size();
            dist++;
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                for (String next : findNext(cur, dict, set)) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    if (next.equals(end)) {
                        return dist;
                    }
                    q.offer(next);
                    visited.add(next);
                    
                }
            }
        }
        return -1;
    }
    
    private List<String> findNext(String cur, char[] dict, HashSet<String> set) {
        List<String> res = new ArrayList<>();
        // traverse all the possible sequence cases
        for (int i = 0; i < cur.length(); i++) {
            // any possible positions
            for (char ch : dict) {
                // permute
                if (ch == cur.charAt(i)) {
                    continue;
                }
                char[] temp = cur.toCharArray();
                temp[i] = ch;
                String next = new String(temp);
                // permutation is in the dictionary
                if (set.contains(next)) {
                    res.add(next);
                }
            }
        }
        return res;
    }
}
