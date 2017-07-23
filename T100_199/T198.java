package T100_199;

public class T198 {
	public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int prev = 0, curr = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;
        }
        return curr;
    }
}
