package C_FaceBook;

public class TTT215 {
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length) return Integer.MIN_VALUE;
        return findKthSmallest(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int findKthSmallest(int[] nums, int left, int right, int k){
        if(left > right) return Integer.MAX_VALUE;
        int pivot = nums[right];
        int curr = left;
        for(int i = left; i < right; i++){
            if(nums[i] <= pivot){
                swap(nums, i, curr);
                curr++;
            }
        }
        swap(nums, curr, right);
        if(curr == k) return nums[k];
        if(curr < k) return findKthSmallest(nums, curr + 1, right, k);
        return findKthSmallest(nums, left, curr - 1, k);
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
