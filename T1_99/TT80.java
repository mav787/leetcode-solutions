package T1_99;

public class TT80 {
	public int removeDuplicates(int[] nums) {
        if(nums == null)
            return -1;
        if(nums.length <= 2)
            return nums.length;
        int curr = 1, unitcount = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                if(unitcount < 2){
                    nums[curr] = nums[i];
                    curr++;
                    unitcount++;
                }
                else{
                    while(i < nums.length && nums[i] == nums[i - 1]){
                        i++;
                    }
                    if(i == nums.length){
                        break;
                    }
                    else{
                        nums[curr] = nums[i];
                        curr++;
                        unitcount = 1;
                    }
                }
            }
            else{
                nums[curr] = nums[i];
                curr++;
                unitcount = 1;
            }
        }
        return curr;
    }
}
