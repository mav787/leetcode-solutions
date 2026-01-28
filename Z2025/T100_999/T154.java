package Z2025.T100_999;

public class T154 {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while(left + 1 < right){
            if(nums[left] < nums[right]){
                // didn't rotate!
                return nums[left];
            }
            else if(nums[left] == nums[right]){
                // can't really tell
                int min = nums[left];
                for(int i = left; i <= right; i++){
                    min = Math.min(min, nums[i]);
                }

                return min;
            }
            else{
                // must be rotated
                int mid = left + (right - left) / 2;
                if(nums[mid] <= nums[right]){
                    right = mid;
                }
                else{
                    left = mid;
                }
            }
        }

        return Math.min(nums[left], nums[right]);
    }
}
