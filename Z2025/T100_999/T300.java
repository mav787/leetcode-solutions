package Z2025.T100_999;

import java.util.*;

public class T300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    //  ========================================================================
    public int lengthOfLIS2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length == 0){
            return 0;
        }

        list.add(nums[0]);

        for(int i = 1; i < nums.length; i++){
            helper(nums[i], list);
        }

        return list.size();
    }

    private void helper(int target, List<Integer> list){
        // find first i that list.get(i) >= target

        int left = 0, right = list.size() - 1;

        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(list.get(mid) >= target){
                right = mid;
            }
            else{
                left = mid;
            }
        }

        if(list.get(left) >= target){
            list.set(left, target);
        }
        else if(list.get(right) >= target){
            list.set(right, target);
        }
        else{
            list.add(target);
        }
    }
}
