package T200_299;

public class T276SaveMemory {
	public int numWays(int n, int k) {
        if(n <= 0 || k <= 0) return 0;
        if(n == 1) return k;
        
        int first = k, second = k * k;
//        int[] dp = new int[n];
//        dp[0] = k;
//        dp[1] = k * k;
        int res = 0;
        for(int i = 2; i < n; i++){
//            dp[i] = (k - 1) * (dp[i - 2] + dp[i - 1]);  // wtf???
        	res = (k - 1) * (first + second);
        	first = second;
        	second = res;
        }
//        return dp[n - 1];
        return second;
    }
}
