package T200_299;

public class T215MyQuickSelect {
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length < k)
            return Integer.MIN_VALUE;
        return findKthSmallest(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int findKthSmallest(int[] nums, int left, int right, int k){
        if(left > right)
            return Integer.MIN_VALUE;
        int curr = left;
        int pivot = nums[right];
        for(int i = left; i < right; i++){
            if(nums[i] < pivot){
                swap(nums, i, curr);
                curr++;
            }
        }
        
        swap(nums, curr, right);
        
        if(curr == k)
            return nums[curr];
        else if(curr < k)
            return findKthSmallest(nums, curr + 1, right, k);
        else
            return findKthSmallest(nums, left, curr - 1, k);
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
