package C_FaceBook;

public class TT80 {
	public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int curr = 0;
        for(int i = 0; i < nums.length; i++){
            if(curr < 2){
                nums[curr] = nums[i];
                curr++;
            }
            else{
                if(nums[i] != nums[curr - 2]){
                    nums[curr] = nums[i];
                    curr++;
                }
            }
        }
        return curr;
    }
}
