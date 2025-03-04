package C_Meta;

public class TTT283 {
	public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int curr = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                continue;
            nums[curr] = nums[i];
            curr++;
        }
        
        for(int i = curr; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
