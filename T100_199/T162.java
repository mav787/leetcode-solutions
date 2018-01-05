package T100_199;

public class T162 {
	public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return 0;
        }
        if(nums.length == 2){
            return nums[0] > nums[1]? 0 : 1;
        }
        
        
        int start = 1, end = nums.length - 2;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            else if(nums[mid] > nums[mid - 1]){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        
        if(nums[start] > nums[start - 1] && nums[start] > nums[start + 1]){
            return start;
        }
        
        if(nums[end] > nums[end - 1] && nums[end] > nums[end + 1]){
            return end;
        }
        return nums[0] > nums[1]? 0 : nums.length - 1;
    }
}
