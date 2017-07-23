package T200_299;

public class T209 {
	public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int start = 0, end = 0, sum = 0, res = Integer.MAX_VALUE;
        while(end < nums.length){
            if(sum < s){
                sum += nums[end];
                end++;
            }
            while(sum >= s){
                res = Math.min(res, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return res == Integer.MAX_VALUE? 0 : res;
    }
}
