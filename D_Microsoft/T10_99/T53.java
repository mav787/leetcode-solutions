package D_Microsoft.T10_99;

public class T53 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        int[] rollingSum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
            sum += nums[i - 1];
            rollingSum[i] = sum;
        }

        int res = Integer.MIN_VALUE;
        int min = 0;
        for(int i = 1; i <= nums.length; i++){
            min = Math.min(min, rollingSum[i - 1]);
            res = Math.max(res, rollingSum[i] - min);
        }
        return res;
    }
}
