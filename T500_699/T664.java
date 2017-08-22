package T500_699;

public class T664 {
	public int strangePrinter(String s) {
		if(s == null || s.length() == 0) return 0;
        int n = s.length();
        
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) 
        	dp[i][i] = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = i + 1;
                for (int k = j + 1; k <= j + i; k++) {
                    int temp = dp[j][k - 1] + dp[k][j + i];
                    if (s.charAt(k - 1) == s.charAt(j + i)) temp--;
                    dp[j][j + i] = Math.min(dp[j][j + i], temp);
                }
            }
        }
        return dp[0][n - 1];
    }
}
