package T100_199;

public class T154 {
	public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        if(nums[0] < nums[nums.length - 1])
            return nums[0];
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[nums.length - 1]){
                right = mid;
            }
            else if(nums[mid] > nums[nums.length - 1]){
                left = mid;
            }
            else{
                return regularFindMin(nums);
            }
        }
        return Math.min(nums[left], nums[right]);
    }
    
    private int regularFindMin(int[] nums){
        if(nums == null || nums.length == 0)
            return -1;
        int res = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < res){
                res = nums[i];
            }
        }
        return res;
    }
}
