package old.T1_99;

public class T5ii {
	private int low, maxlen = 1;
    public String longestPalindrome(String s) {
        int len = s.length();
        int [][] dp = new int[len][len];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if (s.charAt(i) == s. charAt(j) && dp[i+1][j-1] == (j-1) - (i+1) + 1) {
                    dp[i][j] = j - i + 1;
                    if (dp[i][j] > maxlen) {
                        low = i;
                        maxlen = j - i + 1;
                    }
                }
            }
        }
         return s.substring(low, low + maxlen);
    }
}
