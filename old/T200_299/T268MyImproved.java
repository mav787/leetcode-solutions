package old.T200_299;

public class T268MyImproved {
	public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int i = 0, n = nums.length;
        while(i < n){
            if(nums[i] == i || nums[i] == n)
                i++;
            else
                swap(nums, i, nums[i]);
        }
        for(int j = 0; j < n; j++){
            if(nums[j] == n)
                return j;
        }
        return n;
    }
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
