package T500_699;
import java.util.*;
public class T628 {
	public int maximumProduct(int[] nums) {
        if(nums == null || nums.length < 3) return -1;
        Arrays.sort(nums);
        return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3], 
                        nums[0] * nums[1] * nums[nums.length - 1]);
    }
}
