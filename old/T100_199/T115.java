package old.T100_199;

public class T115 {
	public int numDistinct(String s, String t) {
        // array creation
        int[][] dp = new int[s.length() + 1][t.length() + 1];
    
        // filling the first column: with 1s
        for(int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        
        // the first row is 0 by default in every other rows except the first, which we need
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= t.length(); j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[s.length()][t.length()];
    }
}
