package T300_499;

public class T322My {
	public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0) return -1;
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            dp[i] = -1;
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i && dp[i - coins[j]] != -1){
                    min = Math.min(min, dp[i - coins[j]] + 1);
                }
            }
            if(min != Integer.MAX_VALUE){
                dp[i] = min;
            }
        }
        return dp[amount];
    }
}
