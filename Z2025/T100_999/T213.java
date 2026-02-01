package Z2025.T100_999;

public class T213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int left, int right){
        int n = right - left + 1;

        int[] dp = new int[n + 1];
        dp[1] = nums[left];
        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[left + i - 1]);
        }

        return dp[n];
    }
}
