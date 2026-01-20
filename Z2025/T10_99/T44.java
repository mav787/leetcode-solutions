package Z2025.T10_99;

public class T44 {
    public boolean isMatch(String s, String p) {
        if(s == null && p == null){
            return true;
        }
        if(s == null || p == null){
            return false;
        }

        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 0; i < n; i++){
            if(p.charAt(i) == '*'){
                dp[0][i + 1] = true;
            }
            else{
                break;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char cs = s.charAt(i);
                char cp = p.charAt(j);

                if(cs == cp || cp == '?'){
                    dp[i + 1][j + 1] = dp[i][j];
                }
                else if(cp == '*'){
                    dp[i + 1][j + 1] = dp[i + 1][j]     // no char
                                ||  dp[i][j]            // one char
                                ||  dp[i][j + 1];       // multi chars
                }
            }
        }

        return dp[m][n];
    }
}
