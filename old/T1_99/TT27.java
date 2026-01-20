package old.T1_99;

public class TT27 {
	public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int curr = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val) continue;
            nums[curr] = nums[i];
            curr++;
        }
        return curr;
    }
}
