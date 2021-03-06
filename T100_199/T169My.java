package T100_199;

public class T169My {
	public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int count = 0, num = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == num){
                count++;
            }
            else if(count == 0){
                num = nums[i];
                count = 1;
            }
            else{
                count--;
            }
        }
        return num;
    }
}
