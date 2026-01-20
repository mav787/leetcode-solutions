package Z2025.T10_99;

public class T53 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int[] prefixSum = new int[n];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            prefixSum[i] = sum;
        }

        int res = Integer.MIN_VALUE;
        int min = 0;

        for(int i = 0; i < n; i++){
            res = Math.max(res, prefixSum[i] - min);
            min = Math.min(min, prefixSum[i]);
        }

        return res;
    }
}
