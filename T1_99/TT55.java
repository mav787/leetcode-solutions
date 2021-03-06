package T1_99;

public class TT55 {
	public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        int target = nums.length - 1;
        int farthest = 0;
        for(int i = 0; i < nums.length; i++){
            if(i <= farthest){
                farthest = Math.max(farthest, i + nums[i]);
                if(farthest >= target) return true;
            }
            else{
                return false;
            }
        }
        String test = "";
        return false;
    }
}
