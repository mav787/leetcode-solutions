package FaceBook;

public class TT91 {
	public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for(int i = 0; i < len; i++){
            int first = Integer.valueOf(s.substring(i, i + 1));    // exceptions
            if(first >= 1 && first <= 9) dp[i + 1] += dp[i];
            if(i > 0){
                int second = Integer.valueOf(s.substring(i - 1, i + 1));
                if(second >= 10 && second <= 26) dp[i + 1] += dp[i - 1];
            }
        }
        return dp[len];
    }
}
