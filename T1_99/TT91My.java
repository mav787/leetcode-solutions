package T1_99;

public class TT91My {
	public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int[] dp = new int[s.length() + 1];
        if(s.charAt(0) - '0' <= 0 || s.charAt(0) - '0' > 9)
            return 0;
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++){
            int digit = s.charAt(i - 1) - '0';
            int prev = s.charAt(i - 2) - '0';
            if(digit == 0 && (prev > 2 || prev < 1))
                return 0;
            if((prev == 1 && digit > 0 && digit <= 9) || (prev == 2 && digit > 0 && digit <= 6)){
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            else if(digit == 0){        // this case is hard to come up with....
                dp[i] = dp[i - 2];
            }
            else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
