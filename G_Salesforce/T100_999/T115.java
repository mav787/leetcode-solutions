package G_Salesforce.T100_999;

public class T115 {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[2][n + 1];

        // i: 0 - m
        // j: 0 - n

        // s[i] match t[j]

        for(int i = 0; i <= m; i++){
            dp[i % 2][0] = 1;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + dp[(i - 1) % 2][j];
                }
                else{
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                }
            }
        }
        return dp[m % 2][n];

    }
}
