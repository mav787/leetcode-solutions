package T200_299;

public class T239Fast {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) 
        		return new int[0];
        int[] res = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE, index = 0;
        
        for(int i = 0; i < k - 1; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        for(int i = k - 1; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }else if(i - index >= k){
                max = nums[i - k + 1];
                for(int j = i - k + 2; j <= i; j++){
                    if(nums[j] > max){
                        max = nums[j];
                        index = j;
                    }
                }
            }
            res[i - k + 1] = max;
        }
        return res;
    }
}
