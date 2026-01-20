package old.C_Meta.T100_999;

public class T162 {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid - 1]){
                left = mid;
            }
            else{
                right = mid;
            }
        }

        return nums[left] > nums[right] ? left : right;
    }
}
