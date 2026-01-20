package old.T1_99;

public class TT35 {
	public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid;
            }
            else if(nums[mid] == target){
                return mid;
            }
            else{
                left = mid;
            }
        }
        
        //return nums[left] == target ? left : right;
        
        if(nums[right] < target){
            return right + 1;
        }
        else if(nums[left] < target){
            return right;
        }
        else{
            return left;
        }
    }
}
