package old.T500_699;
import java.util.*;

public class T650 {
	public int minSteps(int n) {
        if (n <= 1) return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 2; i * j <= n; j++) {
                // copy takes 1, paste (j - 1) times, j times in total.
                dp[i * j] = Math.min(dp[i * j], dp[i] + 1 + j - 1);     
            }
        }
        return dp[n];
    }
}
