package old.T500_699;

public class T674ii {
	public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                count++;
                res = Math.max(res, count);
            }
            else{
                count = 1;
            }
        }
        return res;
    }
}
