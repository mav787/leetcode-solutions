package T1_99;

public class TT35 {
	public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target)
                left = mid;
            else if(nums[mid] == target)
                return mid;
            else
                right = mid;
        }
        
        if(nums[right] == target)
            return right;
        else if(nums[left] == target)
            return left;
        else {
            if(nums[right] < target)
                return right + 1;
            else if(nums[left] < target && target < nums[right])
                return right;
            else
                return left;
        }
    }
}
