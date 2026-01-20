package old.T1_99;

public class TT41My {
	public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 1;
        int len = nums.length;
        // index : 0 ~ len - 1
        // value : 1 ~ len;
        for(int i = 0; i < len; i++){
            if(nums[i] < 1 || nums[i] > len){
                nums[i] = -1;
            }
            else{
                if(nums[i] != nums[nums[i] - 1]){
                    swap(nums, i, nums[i] - 1);
                    i--;
                }
            }
        }
        for(int i = 0; i < len; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return len + 1;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
