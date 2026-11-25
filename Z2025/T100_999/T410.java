package Z2025.T100_999;

import java.util.*;

public class T410 {
    class Solution {
        public int splitArray(int[] nums, int k) {
            int sum = 0;
            int max = 0;
            for(int num : nums){
                sum += num;
                max = Math.max(max, num);
            }

            int left = max, right = sum;
            while(left + 1 < right){
                int mid = left + (right - left) / 2;
                if(canSplit(nums, mid, k)){
                    right = mid;
                }
                else{
                    left = mid;
                }
            }

            if(canSplit(nums, left, k)){
                return left;
            }
            return right;
        }


        private boolean canSplit(int[] nums, int target, int k){
            int segments = 1;
            int sum = 0;

            for(int i = 0; i < nums.length; i++){
                if(sum + nums[i] <= target){
                    sum += nums[i];
                }
                else{
                    segments++;
                    sum = nums[i];
                    if(segments > k){
                        return false;
                    }
                }
            }

            return true;
        }
    }

}
