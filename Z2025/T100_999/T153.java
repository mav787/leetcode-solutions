package Z2025.T100_999;

public class T153 {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while(left + 1 < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] < nums[right]){
                right = mid;
            }
            else{
                left = mid;
            }
        }

        return Math.min(nums[left], nums[right]);
    }
}
