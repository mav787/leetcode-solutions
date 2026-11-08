package Z2025.T100_999;

import java.util.*;

public class T343 {
    public int integerBreak(int n) {
        if(n < 2){
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }

        return dp[n];
    }
}
