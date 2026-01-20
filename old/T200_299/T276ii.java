package old.T200_299;

public class T276ii {
	public int numWays(int n, int k) {
        if(n <= 0 || k <= 0) return 0;
        if(n == 1) return k;
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k * k;
        for(int i = 2; i < n; i++){
            dp[i] = (k - 1) * (dp[i - 2] + dp[i - 1]);  // wtf???
        }
        return dp[n - 1];
    }
}
