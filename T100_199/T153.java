package T100_199;

public class T153 {
	public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        if(nums[0] < nums[nums.length - 1])
            return nums[0];
        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[nums.length - 1]){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        
        return Math.min(nums[left], nums[right]);
    }
}
