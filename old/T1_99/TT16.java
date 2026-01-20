package old.T1_99;

import java.util.Arrays;

public class TT16 {
	public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return Integer.MAX_VALUE;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, res = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < min){
                    min = Math.abs(sum - target);
                    res = sum;
                }
                if(sum < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return res;
    }
}
