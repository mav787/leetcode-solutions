package T1_99;

public class TT97ii {
	public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null) return false;
        int m = s1.length(), n = s2.length(), k = s3.length();
        if(m + n != k) return false;
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1; i <= m; i++){
            if(s1.charAt(i - 1) == s3.charAt(i - 1)){
                dp[i][0] = true;
            }
            else{
                break;
            }
        }
        
        for(int j = 1; j <= n; j++){
            if(s2.charAt(j - 1) == s3.charAt(j - 1)){
                dp[0][j] = true;
            }
            else{
                break;
            }
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1) && s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                else if(s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i - 1][j];
                }
                else if(s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
