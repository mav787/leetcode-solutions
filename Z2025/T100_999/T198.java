package Z2025.T100_999;

public class T198 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n + 1];

        dp[1] = nums[0];

        for(int i = 1; i < nums.length; i++){
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }

        return dp[n];
    }
}
