package old.T500_699;
import java.util.*;

public class T650My {
	public int minSteps(int n) {
        if(n <= 0) return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                if(i % j == 0){
                    dp[i] = Math.min(dp[i], dp[j] + 1 + i / j - 1);
                }
            }
        }
        return dp[n];
    }
}
