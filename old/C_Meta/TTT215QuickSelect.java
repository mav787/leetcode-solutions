package old.C_Meta;

public class TTT215QuickSelect {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || k < 1 || k > nums.length) return -1;
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int left, int right, int k){
        int pivot = nums[right];
        int curr = left;
        for(int i = left; i < right; i++){
            if(nums[i] > pivot){
                swap(nums, i, curr);
                curr++;
            }
        }
        swap(nums, curr, right);

        if(curr == k - 1) return nums[curr];
        else if(curr < k - 1) return quickSelect(nums, curr + 1, right, k);
        else return quickSelect(nums, left, curr - 1, k);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
