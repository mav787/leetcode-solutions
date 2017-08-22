package T1_99;

public class TT34ii {
	public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int[] res = new int[2];
        int left = 0, right = nums.length - 1;
        // first index : 
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) left = mid;
            else right = mid;
        }
        if(nums[left] == target) res[0] = left;
        else if(nums[right] == target) res[0] = right;
        else res[0] = -1;
        
        left = 0;
        right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target) right = mid;
            else left = mid;
        }
        if(nums[right] == target) res[1] = right;
        else if(nums[left] == target) res[1] = left;
        else res[1] = -1;
        return res;
    }
}
