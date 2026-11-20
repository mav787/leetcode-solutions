package Z2025.T100_999;

import java.util.*;

public class T375 {
    class Solution {
        public int getMoneyAmount(int n) {
            return solve(1, n, new int[n + 1][n + 1]);
        }

        private int solve(int left, int right, int [][] memo) {
            if (left >= right) {
                return 0;
            }

            if(memo[left][right] != 0){
                return memo[left][right];
            }

            int minCost = Integer.MAX_VALUE;

            for (int guess = left; guess <= right; guess++) {
                // Calculate the worst-case cost of guessing this number.
                minCost = Math.min(minCost, guess + Math.max(solve(left, guess - 1, memo), solve(guess + 1, right, memo)));
            }

            memo[left][right] = minCost;
            return minCost;
        }
    }

}
