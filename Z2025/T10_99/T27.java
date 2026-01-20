package Z2025.T10_99;

public class T27 {
    public int removeElement(int[] nums, int val) {
        if(nums == null){
            return 0;
        }

        int curr = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[curr] = nums[i];
                curr++;
            }
        }

        return curr;
    }
}
