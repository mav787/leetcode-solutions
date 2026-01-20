package old.T200_299;

public class T213 {
	public int rob(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    private int rob(int[] nums, int left, int right){
        int res = 0;
        int first = 0, second = 0;
        for(int i = left; i <= right; i++){
            res = Math.max(second, first + nums[i]);
            first = second;
            second = res;
        }
        return res;
    }
}
