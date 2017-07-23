package T1_99;

public class TT75 {
	public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int left = 0, right = nums.length - 1;
        for(int i = 0; i <= right; i++){
            if(nums[i] == 0){
                swap(nums, i, left);
                left++;
            }
            else if(nums[i] == 2){
                swap(nums, i, right);
                i--;
                right--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
