package Z2025.T100_999;

import java.util.*;

public class T313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;

        int length = primes.length;

        // index of the base
        int[] indices = new int[length];


        // next up = base * primes[j]


        for(int i = 1; i < n; i++){
            // calculate dp[i]
            long curr = Long.MAX_VALUE;

            for(int j = 0; j < length; j++){
                curr = Math.min(curr, (long)dp[indices[j]] * primes[j]);
            }


            for(int j = 0; j < length; j++){
                if(curr == (long)dp[indices[j]] * primes[j]){
                    indices[j]++;
                }
            }

            dp[i] = (int)curr;
        }

        return dp[n - 1];
    }
}
