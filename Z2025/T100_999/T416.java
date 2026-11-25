package Z2025.T100_999;

import java.util.*;

public class T416 {
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int num : nums){
                sum += num;
            }

            if(sum % 2 != 0){
                return false;
            }

            int target = sum / 2;
            return helper(nums, 0, target, new boolean[nums.length][target + 1], new boolean[nums.length][target + 1]);
        }

        private boolean helper(int[] nums, int index, int target, boolean[][] visited, boolean[][] memo){
            if(target == 0){
                return true;
            }
            if(index >= nums.length || target < 0){
                return false;
            }

            if(visited[index][target]){
                return memo[index][target];
            }

            visited[index][target] = true;

            boolean result =  helper(nums, index + 1, target, visited, memo) || helper(nums, index + 1, target - nums[index], visited, memo);

            memo[index][target] = result;
            return result;
        }
    }
}
