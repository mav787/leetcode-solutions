package Z2025.T100_999;

import java.util.*;

public class T322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i = 1; i < dp.length; i++){
            int min = Integer.MAX_VALUE;
            for(int coin : coins){
                if(i - coin >= 0 && dp[i - coin] != -1){
                    min = Math.min(min, dp[i - coin] + 1);
                }
            }
            if(min != Integer.MAX_VALUE){
                dp[i] = min;
            }
        }

        return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
    }

}
