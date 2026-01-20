package old.T500_699;

public class T673 {
	public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];        // maxlen with current ending
        int[] count = new int[len];     // times
        int max = 1;
        for(int i = 0; i < len; i++){
            dp[i] = 1;
            count[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    else if(dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        int res = 0;
        for(int i = 0; i < len; i++){
            if(dp[i] == max){
                res += count[i];
            }
        }
        return res;
    }
}
