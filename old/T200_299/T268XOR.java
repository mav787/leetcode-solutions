package old.T200_299;

public class T268XOR {
	public int missingNumber(int[] nums) { //xor
	    int res = nums.length;				// initialize here...
	    for(int i = 0; i < nums.length; i++){
	        res ^= i;
	        res ^= nums[i];
	    }
	    return res;
	}
}
