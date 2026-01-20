package old.T300_499;

public class T338 {
	public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        
        for(int i = 1; i <= num; i++){
            if(i % 2 == 0){
                dp[i] = dp[i / 2];
            }
            else{
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}
