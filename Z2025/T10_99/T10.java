package Z2025.T10_99;

public class T10 {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for(int j = 1; j < p.length(); j++){
            if(p.charAt(j) == '*'){
                dp[0][j + 1] = dp[0][j - 1];
            }
        }


        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < p.length(); j++){
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                    dp[i + 1][j + 1] = dp[i][j];
                }
                else if(p.charAt(j) == '*' && j > 0){
                    dp[i + 1][j + 1] = dp[i + 1][j - 1];

                    char c = p.charAt(j - 1);
                    if(c == '.' || c == s.charAt(i)){
                        dp[i + 1][j + 1] |= dp[i][j + 1];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
