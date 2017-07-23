package T500_699;

public class T644My {
	public double findMaxAverage(int[] nums, int k) {
        if(nums == null || nums.length < k || k <= 0)
            return Double.NEGATIVE_INFINITY;
        double[] avg = new double[nums.length - k + 1];
        int[] count = new int[nums.length - k + 1];
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        avg[0] = (double)sum / k;
        count[0] = k;
        
        for(int i = k; i < nums.length; i++){
            double avgprev = avg[i - k];
            int countprev = count[i - k];
            double sumprev = avgprev * countprev;
            
            double thissum = sumprev + nums[i];
            int thiscount = countprev + 1;
            double thisavg = thissum / thiscount;
            
            int theCount = thiscount;
            
            while(thiscount > k){
                thissum -= nums[i - thiscount + 1];
                thiscount--;
                
                if(thissum / thiscount > thisavg){
                    thisavg = thissum / thiscount;
                    theCount = thiscount;
                }
            }
            avg[i - k + 1] = thisavg;
            count[i - k + 1] = theCount;
        }
        double res = avg[0];
        for(int i = 0; i < avg.length; i++){
            res = Math.max(res, avg[i]);
        }
        return res;
    }
}
