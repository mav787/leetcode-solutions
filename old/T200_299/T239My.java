package old.T200_299;

public class T239My {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) 
        		return new int[0];
        int[] res = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < k; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        
        for(int i = k; i < nums.length; i++){
            res[i - k] = max;
            if(nums[i] >= max){
                max = nums[i];
            }
            else if(nums[i - k] == max){
                max = Integer.MIN_VALUE;
                for(int j = i - k + 1; j <= i; j++){
                    if(nums[j] >= max){
                        max = nums[j];
                    }
                }
            }
        }
        
        res[res.length - 1] = max;
        
        return res;
    }
}
