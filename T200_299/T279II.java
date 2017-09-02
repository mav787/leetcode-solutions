package T200_299;
import java.util.*;
public class T279II {
	public int numSquares(int n) {
        if(n <= 0) return -1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 1; i * i <= n; i++){
            dp[i * i] = 1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j < i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
