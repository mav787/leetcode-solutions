package Z2025.T100_999;

public class T169 {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int res = nums[0], count = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == res || count == 0){
                res = nums[i];
                count++;
            }
            else{
                count--;
                if(count == 0){
                    res = nums[i];
                    count = 1;
                }
            }
        }

        return res;
    }
}
