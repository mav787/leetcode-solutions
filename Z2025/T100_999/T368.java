package Z2025.T100_999;

import java.util.*;

public class T368 {
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            // Sort so we only need to check divisibility with previous elements
            Arrays.sort(nums);

            int n = nums.length;

            // dp[i]: length of the longest divisible subset ending at nums[i]
            // prev[i]: index of the previous element in that subset
            int[] dp = new int[n];
            int[] prev = new int[n];

            // Every element can form a subset of length 1
            Arrays.fill(dp, 1);
            Arrays.fill(prev, -1);

            int maxLen = 0;
            int maxIndex = -1;

            for(int i = 0; i < n; i++){
                // Try extending every valid subset ending before i
                for(int j = 0; j < i; j++){
                    if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }

                // Track the endpoint of the longest subset
                if(dp[i] > maxLen){
                    maxLen = dp[i];
                    maxIndex = i;
                }
            }

            List<Integer> res = new ArrayList<>();

            // Reconstruct the subset by following predecessor indices
            while(maxIndex != -1){
                res.add(nums[maxIndex]);
                maxIndex = prev[maxIndex];
            }

            return res;
        }
    }
}
