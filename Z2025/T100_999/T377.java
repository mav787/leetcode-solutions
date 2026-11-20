package Z2025.T100_999;

import java.util.*;

public class T377 {
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            for(int num : nums){
                if(num < dp.length){
                    dp[num] = 1;
                }
            }

            for(int i = 1; i <= target; i++){
                for(int num : nums){
                    if(num < i){
                        dp[i] += dp[i - num];
                    }
                }
            }

            return dp[target];
        }
    }

}
