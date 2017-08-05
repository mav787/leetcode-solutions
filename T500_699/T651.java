package T500_699;

public class T651 {
	public int maxA(int n) {
        if (n < 1) return 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = i;
        
        for (int i = 1; i < n - 2; i++) {
            for (int j = i + 3; j <= n; j++) {
                dp[j] = Math.max(dp[j], (j - i - 1) * dp[i]);		// num of Ctrl+V 's * dp[i] (clipboard)
            }
        }
        return dp[n];
    }

}
