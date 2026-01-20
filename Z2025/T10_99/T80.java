package Z2025.T10_99;

public class T80 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int index = 1;
        int count = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                if(count >= 2){
                    continue;
                }
                else{
                    nums[index] = nums[i];
                    index++;
                    count++;
                }
            }

            else{
                count = 1;
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}
