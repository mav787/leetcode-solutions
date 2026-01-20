package old.T1_99;

public class TT26 {
	public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int curr = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]) continue;
            nums[curr] = nums[i];
            curr++;
        }
        return curr;
    }
}
