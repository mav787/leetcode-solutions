package T100_199;

public class T152ii {
	public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] mins = new int[nums.length];
        int[] maxs = new int[nums.length];
        
        mins[0] = nums[0];
        maxs[0] = nums[0];
        
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            mins[i] = Math.min(nums[i], Math.min(mins[i - 1] * nums[i], maxs[i - 1] * nums[i]));
            maxs[i] = Math.max(nums[i], Math.max(mins[i - 1] * nums[i], maxs[i - 1] * nums[i]));
            res = Math.max(res, maxs[i]);
        }
        return res;
    }
}
