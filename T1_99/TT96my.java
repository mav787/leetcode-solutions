package T1_99;

public class TT96my {
	public int numTrees(int n) {
        if(n <= 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            // total of i nodes
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
