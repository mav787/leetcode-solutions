package C_FaceBook;

public class TT10 {
	public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 2; i <= n; i++){
            if(p.charAt(i - 1) == '*' && dp[0][i - 2]){
                dp[0][i] = true;        // zero preceding element
            }
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    
                    if(p.charAt(j - 1) == '.'){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    else if(p.charAt(j - 1) == '*'){
                        if(j == 1){
                            dp[i][j] = false;
                        }
                        else if(p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.'){
                        // false char. should be NO CHAR
                            dp[i][j] = dp[i][j - 2];
                        }
                        else{
                            dp[i][j] = dp[i][j - 2]     // no char
                                    || dp[i][j - 1]     // one char
                                    || dp[i - 1][j];    // more chars
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }
}
