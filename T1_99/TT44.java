package T1_99;

public class TT44 {
	public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int j = 1; j <= n; j++){
            if(p.charAt(j - 1) == '*' && dp[0][j - 1]){
                dp[0][j] = true;
            }
            else{
                break;
            }
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 1]     // no char
                            || dp[i - 1][j - 1] // one char
                            || dp[i - 1][j];    // more chars
                }
            }
        }
        
        return dp[m][n];
    }
}
