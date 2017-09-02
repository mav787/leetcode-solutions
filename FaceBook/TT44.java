package FaceBook;

public class TT44 {
	public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1; i <= p.length(); i++){
            if(dp[0][i - 1] && p.charAt(i - 1) == '*')
                dp[0][i] = true;
            else
                break;
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char cs = s.charAt(i - 1);
                char cp = p.charAt(j - 1);
                if(cs == cp){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(cp == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(cp == '*'){
                    dp[i][j] = dp[i - 1][j - 1]     // one char
                            || dp[i - 1][j]         // multi chars
                            || dp[i][j - 1];        // no char
                }
            }
        }
        return dp[m][n];
    }
}
