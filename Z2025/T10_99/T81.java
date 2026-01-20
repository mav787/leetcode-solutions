package Z2025.T10_99;

public class T81 {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }

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
            else if(nums[mid] == nums[left]){
                for(int num : nums){
                    if(num == target){
                        return true;
                    }
                }
                return false;
            }
            else{
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid;
                }
                else{
                    right = mid;
                }
            }
        }

        return nums[left] == target || nums[right] == target;
    }
}
