package Z2025.T100_999;

public class T132 {
    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int n = s.length();
        int[][] dp = new int[n][n];

        // initialize
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // dp[i][j]: num of cuts for s[i, j]
        for(int i = 0; i < n; i++){
            int j = 0;
            // 1. expand from s[i][i]
            while(i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j)){
                dp[i - j][i + j] = 0;
                j++;
            }

            // 2. expand from s[i][i + 1]
            j = 0;
            while(i - j >= 0 && i + 1 + j < n && s.charAt(i - j) == s.charAt(i + 1 + j)){
                dp[i - j][i + 1 + j] = 0;
                j++;
            }
        }

        // calculate dp[0][i] - > dp[0][j] + dp[j + 1][i]
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(dp[0][j] != Integer.MAX_VALUE && dp[j + 1][i] == 0){
                    dp[0][i] = Math.min(dp[0][i], 1 + dp[0][j]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
