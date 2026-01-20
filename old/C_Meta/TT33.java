package old.C_Meta;

public class TT33 {
	public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[left]){
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid;
                }
                else{
                    left = mid;
                }
            }
            else{
                // nums[mid] <= nums[left]
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid;
                }
                else{
                    right = mid;
                }
            }
        }
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }
}
