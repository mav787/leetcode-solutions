package Z2025.T10_99;

import java.util.Arrays;

public class T16 {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int res = 0;
        if(nums == null || nums.length < 3){
            return res;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - sum) < diff){
                    diff = Math.abs(target - sum);
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
