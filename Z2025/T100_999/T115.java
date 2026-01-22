package Z2025.T100_999;

public class T115 {
    public int numDistinct(String s, String t) {
        if(s == null || t == null){
            return -1;
        }

        if(s.length() < t.length()){
            return 0;
        }

        int m = s.length(), n = t.length();

        int[][] dp = new int[2][n + 1];
        for(int i = 0; i <= m; i++){
            dp[i % 2][0] = 1;
        }

        // use chars in s to match chars in t
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[(i + 1) % 2][j + 1] = dp[i % 2][j + 1];
                char ci = s.charAt(i), cj = t.charAt(j);
                if(ci == cj){
                    dp[(i + 1) % 2][j + 1] += dp[i % 2][j];
                }
            }
        }

        return dp[m % 2][n];
    }
}
