package old.T1_99;

public class TT41 {
	public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 1;
        int i = 0, len = nums.length; 
        while(i < len){
            if(nums[i] < 1 || nums[i] > len)
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
        for(int j = 0; j < len; j++){
            if(nums[j] != j + 1)
                return j + 1;
        }
        return len + 1;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
