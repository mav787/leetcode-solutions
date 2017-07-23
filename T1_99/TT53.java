package T1_99;

public class TT53 {
	public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int globalmax = Integer.MIN_VALUE;
        int currentmax = 0;
        for(int i = 0; i < nums.length; i++){
            currentmax = Math.max(currentmax + nums[i], nums[i]);
            globalmax = Math.max(globalmax, currentmax);
        }
        return globalmax;
    }
}
