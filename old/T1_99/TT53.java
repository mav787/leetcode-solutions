package old.T1_99;

public class TT53 {
	public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int curr = 0;
        int res = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            curr = Math.max(curr + nums[i], nums[i]);
            res = Math.max(res, curr);
        }
        return res;
    }
}
