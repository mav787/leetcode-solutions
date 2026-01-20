package Z2025.T10_99;

public class T31 {
    public void nextPermutation(int[] nums) {
        // 1. linear scan from right to left
        // 2. if decrease:
        // 3. swap with min
        // 4. reverse the right

        if(nums == null || nums.length < 2){
            return;
        }

        int right = nums.length - 1;
        int left = right - 1;
        while(left >= 0 && nums[right] <= nums[left]){
            right--;
            left--;
        }

        if(left < 0){
            reverse(nums, 0);
            return;
        }

        for(int i = nums.length - 1; i > left; i--){
            if(nums[i] > nums[left]){
                swap(nums, left, i);
                break;
            }
        }

        reverse(nums, right);
    }


    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void reverse(int[] nums, int left){
        int right = nums.length - 1;
        while(left <= right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
