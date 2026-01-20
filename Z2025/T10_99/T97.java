package Z2025.T10_99;

public class T97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null){
            return false;
        }
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }


        int m = s1.length(), n = s2.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for(int i = 0; i < m; i++){
            if(s1.charAt(i) == s3.charAt(i)){
                dp[i + 1][0] = true;
            }
            else{
                break;
            }
        }

        for(int j = 0; j < n; j++){
            if(s2.charAt(j) == s3.charAt(j)){
                dp[0][j + 1] = true;
            }
            else{
                break;
            }
        }


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char c1 = s1.charAt(i), c2 = s2.charAt(j), c3 = s3.charAt(i + j + 1);
                if(c3 == c1 && c3 == c2){
                    dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
                }
                else if(c3 == c1){
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
                else if(c3 == c2){
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
                else{
                    dp[i + 1][j + 1] = false;
                }
            }
        }

        return dp[m][n];
    }
}
