package old.T1_99;

public class TT81 {
	public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return false;
        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[left] < nums[mid]){
                if(nums[left] <= target && target <= nums[mid])
                    right = mid;
                else
                    left = mid;
            }
            else if(nums[left] == nums[mid]){
                for(int i = left; i <= right; i++){
                    if(nums[i] == target)
                        return true;
                }
                return false;
            }
            else{
                // nums[left] > nums[mid]
                if(nums[mid] <= target && target <= nums[right])
                    left = mid;
                else
                    right = mid;
            }
        }
        if(nums[left] == target)
            return true;
        else if(nums[right] == target)
            return true;
        else
            return false;
    }
}
