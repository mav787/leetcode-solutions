package T300_499;
import java.util.*;
public class T300 {
	public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        // dp[0] = 1;
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 1;
        for(int i = 0; i < dp.length; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
