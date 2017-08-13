package T1_99;

public class TT10 {
	public boolean isMatch(String s, String p) {
        if(s == null || p == null)
            return false;
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int j = 1; j <= n; j++){
            if(j > 1 && dp[0][j - 2] && p.charAt(j - 1) == '*')	// no char
                dp[0][j] = true;
        }
        
        for(int i = 1; i <= m; i++){
            char cs = s.charAt(i - 1);
            for(int j = 1; j <= n; j++){
                char cp = p.charAt(j - 1);
                if(cs == cp){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(cp == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(cp == '*'){
                    if(j == 1)
                        dp[i][j] = false;
                    else{
                        if (p.charAt(j - 2) != cs && p.charAt(j - 2) != '.') {
                            dp[i][j] = dp[i][j - 2];	// no char
                        } else {
                            dp[i][j] = (dp[i][j - 1]    // one char
                                     || dp[i - 1][j]    // more chars
                                     || dp[i][j - 2]);  // no char
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }
}
