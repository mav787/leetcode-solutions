package T1_99;

public class TT27 {
	public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0)
            return 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val)
                continue;
            else
                nums[count++] = nums[i];
        }
        return count;
    }
}
