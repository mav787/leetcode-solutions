package Z2025.T10_99;

public class T34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }

    private int findFirst(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid;
            }
            else{
                left = mid;
            }
        }

        if(nums[left] == target){
            return left;
        }
        if(nums[right] == target){
            return right;
        }
        return -1;
    }

    private int findLast(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid;
            }
            else{
                right = mid;
            }
        }

        if(nums[right] == target){
            return right;
        }
        if(nums[left] == target){
            return left;
        }
        return -1;
    }
}
