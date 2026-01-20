package old.T200_299;

public class T264my {
	public int nthUglyNumber(int n) {
        if(n <= 0) return -1;
        if(n == 0) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        
        // int factor2 = 2, factor3 = 3, factor5 = 5;
        int index2 = 0, index3 = 0, index5 = 0;
        
        for(int i = 1; i < n; i++){
            dp[i] = Math.min(2 * dp[index2], Math.min(3 * dp[index3], 5 * dp[index5]));
            if(dp[i] == 2 * dp[index2]){
                index2++;
            }
            if(dp[i] == 3 * dp[index3]){
                index3++;
            }
            if(dp[i] == 5 * dp[index5]){
                index5++;
            }
        }
        return dp[n - 1];
    }
}
