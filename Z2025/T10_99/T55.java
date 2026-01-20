package Z2025.T10_99;

public class T55 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return true;
        }

        int farthest = 0;
        for(int i = 0; i < nums.length; i++){
            if(i <= farthest){
                farthest = Math.max(farthest, i + nums[i]);
            }
        }

        return farthest >= nums.length - 1;
    }
}
