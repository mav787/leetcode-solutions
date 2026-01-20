package old.T300_499;
import java.util.*;
public class T300 {
	public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int res = 1;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
