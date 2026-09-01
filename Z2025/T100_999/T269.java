package Z2025.T100_999;

import java.util.*;

public class T269 {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0){
            return "";
        }

        Map<Character, Integer> inDegrees = new HashMap<>();
        Map<Character, List<Character>> outEdges = new HashMap<>();

        // init
        for(String word : words) {
            for(char c : word.toCharArray()) {
                outEdges.putIfAbsent(c, new ArrayList<>());
                inDegrees.putIfAbsent(c, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String s1 = words[i], s2 = words[i + 1];

            if(s1.length() > s2.length() && s1.startsWith(s2)){
                // invalid
                return "";
            }

            int len1 = s1.length(), len2 = s2.length();
            for(int j = 0; j < Math.min(len1, len2); j++){
                char c1 = s1.charAt(j), c2 = s2.charAt(j);
                if(c1 == c2){
                    continue;
                }
                // c1 != c2, c1 should < c2
                // c1 -> c2
                outEdges.get(c1).add(c2);
                inDegrees.put(c2, inDegrees.get(c2) + 1);
                break;
            }
        }

        // topo sort
        Queue<Character> queue = new LinkedList<>();
        for(char c : inDegrees.keySet()){
            if(inDegrees.get(c) == 0){
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                char c = queue.poll();
                sb.append(c);
                for(char neighbor : outEdges.get(c)){
                    inDegrees.put(neighbor, inDegrees.get(neighbor) - 1);
                    if(inDegrees.get(neighbor) == 0){
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return sb.length() == inDegrees.keySet().size() ? sb.toString() : "";
    }
}
