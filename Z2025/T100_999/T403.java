package Z2025.T100_999;

import java.util.*;

public class T403 {
    class Solution {
        public boolean canCross(int[] stones) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            int dest = stones[stones.length - 1];

            for(int stone : stones){
                map.put(stone, new HashSet<>());
            }

            if(stones[1] != 1){
                return false;
            }

            map.get(1).add(1);

            return helper(map, 1, dest, 1);
        }

        private boolean helper(Map<Integer, Set<Integer>> map, int curr, int dest, int k){
            if(curr == dest){
                return true;
            }
            if(curr > dest){
                return false;
            }

            int[] steps = {k - 1, k, k + 1};

            for(int i = 0; i < steps.length; i++){
                int next = curr + steps[i];
                int step = steps[i];
                if (step <= 0) {
                    continue;
                }

                if(!map.containsKey(next)){
                    continue;
                }

                if(map.get(next).add(step)){
                    if(helper(map, next, dest, step)){
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
