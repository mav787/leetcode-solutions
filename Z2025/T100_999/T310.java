package Z2025.T100_999;

import java.util.*;

public class T310 {
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> res = new ArrayList<>();

            if(n < 2){
                for(int i = 0; i < n; i++){
                    res.add(i);
                }

                return res;
            }

            Map<Integer, Set<Integer>> map = new HashMap<>();
            for(int i = 0; i < edges.length; i++){
                int a = edges[i][0];
                int b = edges[i][1];

                Set<Integer> aNeighbor = map.getOrDefault(a, new HashSet<>());
                aNeighbor.add(b);
                map.put(a, aNeighbor);

                Set<Integer> bNeighbor = map.getOrDefault(b, new HashSet<>());
                bNeighbor.add(a);
                map.put(b, bNeighbor);
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i : map.keySet()){
                if(map.get(i).size() <= 1){
                    queue.offer(i);
                }
            }


            while(map.size() > 2){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int key = queue.poll();
                    Set<Integer> neighbors = map.get(key);
                    map.remove(key);
                    for(int neighbor : neighbors){
                        map.get(neighbor).remove(key);
                        if(map.get(neighbor).size() == 1){
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            for(int key : map.keySet()){
                res.add(key);
            }
            return res;
        }
    }
}
