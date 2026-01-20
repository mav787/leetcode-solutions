package old.G_Salesforce.T1000_9999;

public class T2016 {
    public int maximumDifference(int[] nums) {
        int res = -1;
        if(nums == null || nums.length <= 1){
            return res;
        }

        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= min){
                min = nums[i];
            }
            else{
                res = Math.max(res, nums[i] - min);
            }
        }

        return res;
    }
}
