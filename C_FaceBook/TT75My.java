package C_FaceBook;

public class TT75My {
	public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        // red : 0, white : 1, blue : 2
        int redCount = 0, blueCount = 0;
        int i = 0;
        while(i < nums.length - blueCount){
            if(nums[i] == 0){
                swap(nums, i, redCount);
                redCount++;
                i++;
            }
            else if(nums[i] == 1){
                i++;
            }
            else if(nums[i] == 2){
                swap(nums, i, nums.length - 1 - blueCount);
                blueCount++;
                // no i++ here
            }
        }
    }
    
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
