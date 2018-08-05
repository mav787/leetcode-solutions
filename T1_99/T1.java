package T1_99;

import java.util.*;

public class T1 {
	public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]) - 1;
                return result;
            }
            map.put(nums[i], i + 1);
        }
        return result;
    }
}
