package T100_199;

public class T152 {
	public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int res = nums[0];
        int maxpre = nums[0], minpre = nums[0], max = nums[0], min = nums[0];
    
        for(int i = 1; i < nums.length; i++){
            min = Math.min(nums[i], Math.min(nums[i] * minpre, nums[i] * maxpre));
            max = Math.max(nums[i], Math.max(nums[i] * minpre, nums[i] * maxpre));
            minpre = min;
            maxpre = max;
            res = Math.max(res, max);
        }
        return res;
    }
}
