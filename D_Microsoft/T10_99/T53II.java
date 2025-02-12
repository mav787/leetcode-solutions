package D_Microsoft.T10_99;

public class T53II {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int curr = 0, res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            curr = Math.max(curr + nums[i], nums[i]);
            res = Math.max(res, curr);
        }
        return res;
    }
}
