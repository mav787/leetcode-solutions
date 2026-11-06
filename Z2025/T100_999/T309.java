package Z2025.T100_999;

import java.util.*;

public class T309 {

    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][3];

            // 0: hold at end of day i
            // 1: sold on day i
            // 2: not holding on day i

            dp[0][0] = -prices[0];          // buy to hold
            dp[0][1] = Integer.MIN_VALUE;   // illegal
            dp[0][2] = 0;                   // no trading

            for(int i = 1; i < n; i++){
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
                dp[i][1] = dp[i - 1][0] + prices[i];
                dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            }

            return Math.max(dp[n - 1][1], dp[n - 1][2]);
        }
    }


}
