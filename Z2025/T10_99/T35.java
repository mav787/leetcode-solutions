package Z2025.T10_99;

public class T35 {
    public int searchInsert(int[] nums, int target) {
        // find smallest index that nums[i] >= target
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums[nums.length - 1] < target){
            return nums.length;
        }

        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid;
            }
            else if(nums[mid] == target){
                return mid;
            }
            else{
                right = mid;
            }
        }

        if(nums[left] >= target){
            return left;
        }
        else{
            return right;
        }
    }
}
