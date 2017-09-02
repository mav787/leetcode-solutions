package T300_499;

public class T322 {
	public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        int[] dp = new int[amount + 1];

        for(int i = 1; i <= amount; i++){
            int min = -1;
            for(int j = 0; j < coins.length; j++) {
                if(i >= coins[j] && dp[i - coins[j]] != -1) {
                    int temp = dp[i - coins[j]] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[i] = min;
        }
        return dp[amount];
    }
}
