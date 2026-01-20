package Z2025.T10_99;

public class T75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;

        for(int i = 0; i <= right; i++){
            if(nums[i] == 0){
                swap(nums, i, left);
                left++;
            }
            else if(nums[i] == 2){
                swap(nums, i, right);
                right--;
                i--;
            }
        }
    }


    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
