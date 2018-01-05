package C_FaceBook;

public class TTT215QuickSelect {
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || k < 1 || k > nums.length) return -1;
        return findKthSmallest(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int findKthSmallest(int[] nums, int left, int right, int k){
        int pivot = nums[right];
        int curr = left;
        for(int i = left; i < right; i++){
            if(nums[i] < pivot){
                swap(nums, i, curr);
                curr++;
            }
        }
        swap(nums, curr, right);
        
        if(curr == k) return nums[k];
        if(curr < k) return findKthSmallest(nums, curr + 1, right, k);
        return findKthSmallest(nums, left, curr - 1, k);
    }
    
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
