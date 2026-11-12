package Z2025.T100_999;

import java.util.*;

public class T358 {

    class Solution {
        public String rearrangeString(String s, int k) {
            int len = s.length();
            Map<Character, Integer> map = new HashMap<>();
            for(char c : s.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            Queue<Node> heap = new PriorityQueue<>((a, b) -> b.count - a.count);
            for(char c : map.keySet()){
                heap.offer(new Node(c, map.get(c)));
            }

            Queue<Node> cooldown = new LinkedList<>();
            StringBuilder sb = new StringBuilder();

            while(sb.length() < len){
                int index = sb.length();

                // Release characters whose cooldown has expired
                while(!cooldown.isEmpty() &&
                        index - cooldown.peek().lastIndex >= k){
                    heap.offer(cooldown.poll());
                }

                // No available character
                if(heap.isEmpty()){
                    return "";
                }

                // Pick the available character with highest frequency
                Node node = heap.poll();

                sb.append(node.c);
                node.count--;
                node.lastIndex = index;

                // Wait until this character becomes available again
                if(node.count > 0){
                    cooldown.offer(node);
                }
            }

            return sb.toString();
        }

        class Node {
            char c;
            int count;
            int lastIndex;

            public Node(char c, int count){
                this.c = c;
                this.count = count;
                this.lastIndex = -1;
            }
        }
    }
}
