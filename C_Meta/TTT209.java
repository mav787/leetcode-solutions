package C_Meta;

public class TTT209 {
	public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        
        int left = 0, right = 0;
        while(right < nums.length){
            if(sum < s){
                sum += nums[right];
                right++;
            }
            while(sum >= s){
                res = Math.min(res, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
