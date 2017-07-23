package T100_199;
import java.util.*;

public class T128 {
	public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for(int item : nums){
            set.add(item);
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i] - 1)){		// nums[i] is the first one in the sequence
                int curr = nums[i] + 1;
                while(set.contains(curr)){
                    curr += 1;
                }
                res = Math.max(res, curr - nums[i]);
            }
        }
        return res;
    }
}
