package old.T100_199;

public class T162ii {
	public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;

        int left = 0, right = len - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if(left == len - 1) return left;
        return nums[left] > nums[left + 1] ? left : right;
    }
}
