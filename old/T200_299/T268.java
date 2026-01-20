package old.T200_299;

public class T268 {
	public int missingNumber(int[] nums) {
        int xor = nums.length;
        for(int i = 0; i < nums.length; i++){
            xor ^= i;
            xor ^= nums[i];
        }
        return xor;
    }
}
