package E_Microsoft;

public class TT26 {
	public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int curr = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                nums[curr++] = nums[i];
            }
            else if(nums[i] != nums[i - 1]){
                nums[curr++] = nums[i];
            }
        }
        return curr;
    }
}
