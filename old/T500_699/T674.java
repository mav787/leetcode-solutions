package old.T500_699;

public class T674 {
	public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 1;
        int i = 0;
        while(i < nums.length){
            int count = 1;
            int j = i + 1;
            while(j < nums.length && nums[j] > nums[j - 1]){
                count = j - i + 1;
                res = Math.max(res, count);
                j++;
            }
            i = j;
        }
        return res;
    }
}
