package T100_199;

public class T198myOptimizedMemory {
	public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        // int[] dp = new int[nums.length + 1];
        // dp[0] = 0;
        // dp[1] = nums[0];
        int first = 0, second = nums[0];
        int res = nums[0];
        for(int i = 2; i < nums.length + 1; i++){
            // dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
            res = Math.max(second, first + nums[i - 1]);
            first = second;
            second = res;
        }
        return res;
        // return dp[dp.length - 1];
    }
}
