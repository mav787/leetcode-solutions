package Z2025.T100_999;

import java.util.*;

public class T398 {
    class Solution {
        Map<Integer, List<Integer>> map;
        Random random;

        public Solution(int[] nums) {
            map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                int num = nums[i];
                List<Integer> list = map.getOrDefault(num, new ArrayList<>());
                list.add(i);
                map.put(num, list);
            }

            random = new Random();
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            return list.get(random.nextInt(list.size()));
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

}
