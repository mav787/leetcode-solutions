package T200_299;

public class T213My {
	public int rob(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    private int rob(int[] nums, int left, int right){
        int res = nums[left];
        int first = 0, second = nums[left];
        for(int i = left + 1; i <= right; i++){
            res = Math.max(second, first + nums[i]);
            first = second;
            second = res;
        }
        return res;
    }
}
