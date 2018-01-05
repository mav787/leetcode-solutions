package T500_699;

public class T651 {
	public int maxA(int n) {
        if (n < 1) return 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
        	dp[i] = i;
        }
        
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i - 2; j++){
                dp[i] = Math.max(dp[i], dp[j] * (i - 2 - j + 1));
            }
        }
        return dp[n];
    }

}
