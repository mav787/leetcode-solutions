package FaceBook;

public class TT26 {
	public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int curr = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                nums[curr] = nums[i];
                curr++;
            }
        }
        return curr;
    }
}
