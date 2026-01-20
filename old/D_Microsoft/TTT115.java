package old.D_Microsoft;

public class TTT115 {
	public int numDistinct(String S, String T) {
        // array creation
        int[][] dp = new int[T.length() + 1][S.length() + 1];
    
        // filling the first row: with 1s
        for(int j = 0; j <= S.length(); j++) {
            dp[0][j] = 1;
        }
        
        // the first column is 0 by default in every other rows but the first, which we need.
        
        for(int i = 1; i <= T.length(); i++) {
            for(int j = 1; j <= S.length(); j++) {
                if(T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        
        return dp[T.length()][S.length()];
    }
}
