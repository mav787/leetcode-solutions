package D_Microsoft;

public class TT55 {
	public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(i <= max){
                max = Math.max(max, i + nums[i]);
                if(max >= nums.length - 1) return true;
            }
        }
        return false;
    }
}
