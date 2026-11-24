package Z2025.T100_999;

import java.util.*;

public class T397 {
    class Solution {
        public int integerReplacement(int n) {
            Map<Long, Integer> map = new HashMap<>();
            map.put(1L, 0);

            return helper((long)n, map);
        }

        private int helper(long i, Map<Long, Integer> map){
            if(map.containsKey(i)){
                return map.get(i);
            }

            if(i % 2 == 0){
                map.put(i, helper(i / 2, map) + 1);
            }
            else{
                map.put(i, Math.min(helper(i - 1, map), helper(i + 1, map)) + 1);
            }

            return map.get(i);
        }
    }
}
