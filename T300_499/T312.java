package T300_499;

public class T312 {
	public int maxCoins(int[] nums) {
	    if (nums == null || nums.length == 0) return 0;
	    
	    int[][] dp = new int[nums.length][nums.length];
	    for (int i = 1; i <= nums.length; i++) {
	        for (int start = 0; start <= nums.length - i; start++) {
	            int end = start + i - 1;
	            for (int j = start; j <= end; j++) {
	                int coins = nums[j] * getValue(nums, start - 1) * getValue(nums, end + 1);
	                coins += j != start ? dp[start][j - 1] : 0; // If not first one, we can add subrange on its left.
	                coins += j != end ? dp[j + 1][end] : 0; // If not last one, we can add subrange on its right
	                dp[start][end] = Math.max(dp[start][end], coins);
	            }
	        }
	    }
	    return dp[0][nums.length - 1];
	}

	private int getValue(int[] nums, int i) { // Deal with num[-1] and num[num.length]
	    if (i < 0 || i >= nums.length) {
	        return 1;
	    }
	    return nums[i];
	}
}
