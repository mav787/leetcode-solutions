package T500_699;

public class T643 {
	public double findMaxAverage(int[] nums, int k) {
        if(nums == null || nums.length < k)
            return Double.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        
        double res = (double)sum / k;
        for(int i = k; i < nums.length; i++){
            sum += nums[i];
            sum -= nums[i - k];
            res = Math.max(res, (double)sum / k);
        }
        return res;
    }
}
