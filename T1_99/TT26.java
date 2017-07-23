package T1_99;

public class TT26 {
	public int removeDuplicates(int[] nums) {
        if(nums == null)
            return 0;
        if(nums.length < 2)
            return nums.length;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1])
                continue;
            else{
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
