package T300_499;

public class T357 {
	public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int res = 10;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;
        int rest = 9;
        for(int i = 2; i <= n && rest > 0; i++){
            dp[i] = dp[i - 1] * rest;
            rest--;
            res += dp[i];
        }
        return res;
    }
}
