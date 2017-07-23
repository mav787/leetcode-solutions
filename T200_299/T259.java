package T200_299;
import java.util.*;

public class T259 {
	public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3)
            return 0;
        int res = 0;
        Arrays.sort(nums);
        for(int left = 0; left < nums.length - 2; left++){
            res += numOfPairs(nums, left + 1, nums.length - 1, target - nums[left]);
        }
        return res;
    }
    
    // Calculate the number of different pairs that sums to a number less than the target
    private int numOfPairs(int[] nums, int start, int end, int target){
        int res = 0;
        while(start < end){
            int sum = nums[start] + nums[end];
            if(sum < target){
                res += end - start;
                start++;
            }
            else{
                end--;
            }
        }
        return res;
    }
}
