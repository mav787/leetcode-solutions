package T500_699;
import java.util.*;

public class T506 {
	public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        if(nums == null || nums.length == 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            res[map.get(nums[i])] = nums.length - i + "";
            if(i == nums.length - 1)
                res[map.get(nums[i])] = "Gold Medal";
            if(i == nums.length - 2)
                res[map.get(nums[i])] = "Silver Medal";
            if(i == nums.length - 3)
                res[map.get(nums[i])] = "Bronze Medal";
        }
        return res;
    }
}