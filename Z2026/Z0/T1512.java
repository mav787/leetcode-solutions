package Z2026.Z0;

import java.util.*;

public class T1512 {
    class Solution {
        public int numIdenticalPairs(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int num : nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int res = 0;
            for(int num : map.keySet()){
                int count = map.get(num);
                res += count * (count - 1) / 2;
            }

            return res;
        }
    }

}
