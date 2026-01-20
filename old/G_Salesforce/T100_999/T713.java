package old.G_Salesforce.T100_999;

public class T713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 1){
            return 0;
        }

        int product = 1, left = 0, right = 0;
        int res = 0;

        for(right = 0; right < nums.length; right++){
            product *= nums[right];
            while(product >= k){
                product /= nums[left];
                left++;
            }
            // definition: the candidate items must include nums[right]
            res += right - left + 1;
        }
        return res;
    }
}
