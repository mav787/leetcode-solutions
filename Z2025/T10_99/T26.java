package Z2025.T10_99;

public class T26 {
    public int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }

        if(nums.length <= 1){
            return nums.length;
        }

        int curr = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                continue;
            }
            else{
                nums[curr] = nums[i];
                curr++;
            }
        }

        return curr;
    }
}
