package T1_99;

import java.util.Arrays;

public class TT16 {
	
//	Similar to 3 Sum problem, use 3 pointers to point current element, next element and 
//	the last element. If the sum is less than target, it means we have to add a larger 
//	element so next element move to the next. If the sum is greater, it means we have 
//	to add a smaller element so last element move to the second last element. Keep doing
//	this until the end. Each time compare the difference between sum and target, if it is
//	less than minimum difference so far, then replace result with it, otherwise keep iterating.
	public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3)
            return Integer.MAX_VALUE;
        Arrays.sort(nums);
        int res = 0, mindiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < mindiff){
                    mindiff = Math.abs(sum - target);
                    res = sum;
                }
                if(sum < target)
                    left++;
                else
                    right--;
            }
        }
        return res;
    }
}
