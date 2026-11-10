package Z2025.T100_999;

import java.util.*;

public class T356 {

    class Solution {
        public boolean isReflected(int[][] points) {
            // group points based on y coordinates  - O(N)
            if(points == null || points.length == 0){
                return false;
            }

            Map<Integer, Set<Integer>> map = new HashMap<>();
            for(int i = 0; i < points.length; i++){
                int x = points[i][0], y = points[i][1];

                Set<Integer> set = map.getOrDefault(y, new HashSet<>());
                set.add(x);
                map.put(y, set);
            }

            // for each group: a group of x coordinates
            // find center if any. this must be the avg of sum(x).
            // validate for each pair.

            long res = Long.MAX_VALUE;

            for(int y : map.keySet()){
                Set<Integer> set = map.get(y);
                long center = findCenter(set);
                if(center == Long.MAX_VALUE){
                    return false;
                }
                if(res == Long.MAX_VALUE){
                    res = center;
                }
                if(center != res){
                    return false;
                }
            }

            // validate every group has a center and all centers are the same
            return true;
        }

        private long findCenter(Set<Integer> set){
            long sum = 0;
            for(int item : set){
                sum += item;
            }

            long doubleAvg = 2 * sum / set.size();

            for(int item : set){
                long mirror = doubleAvg - item;
                if(mirror < Integer.MIN_VALUE ||
                        mirror > Integer.MAX_VALUE ||
                        !set.contains((int) mirror)){
                    return Long.MAX_VALUE;
                }
            }
            return doubleAvg;
        }
    }
}
