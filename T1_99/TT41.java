package T1_99;

public class TT41 {
	public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 1;
        int i = 0, n = nums.length; 
        while(i < n){
            if(nums[i] < 1 || nums[i] > n)
                i++;
            else if(nums[i] == i + 1)
                i++;
            else if(nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
            else{
                i++;
            }
        }
        for(int j = 0; j < n; j++){
            if(nums[j] != j + 1)
                return j + 1;
        }
        return n + 1;
    }
    
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
