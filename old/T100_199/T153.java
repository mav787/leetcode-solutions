package old.T100_199;

public class T153 {
	public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[nums.length - 1]){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
