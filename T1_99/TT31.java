package T1_99;

public class TT31 {
	public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int find = nums.length - 1;
        while(find >= 1){
            if(nums[find] > nums[find - 1])
                break;
            find--;
        }
        if(find != 0){
            // swap(find - 1, smallest but larger than find - 1)
            int index = nums.length - 1;
            while(index >= find){
                if(nums[index] > nums[find - 1]){
                    //swap(nums, index, find - 1);
                    break;
                }
                index--;
            }
            swap(nums, index, find - 1);
        }
        reverse(nums, find);
    }
    
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    private void reverse(int[] nums, int find){
        int left = find, right = nums.length - 1;
        while(left < right){
            swap(nums, left, right);
            left++; 
            right--;
        }
    }
}
