package T300_499;

public class T453 {
	public int minMoves(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int i : nums){
            min = Math.min(min, i);
        }
        
        int res = 0;
        for(int i : nums){
            res += i - min;
        }
        return res;
    }
}
