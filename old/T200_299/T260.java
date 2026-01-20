package old.T200_299;

public class T260 {
	public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length < 2)
            return new int[2];
        int xor = 0;
        for(int i : nums){
            xor ^= i;
        }
        
        // rightmost set bit
        int bit = xor & ~(xor - 1);
        
        int num1 = 0, num2 = 0;
        for(int i : nums){
            if((i & bit) != 0){
                num1 ^= i;
            }
            else{
                num2 ^= i;
            }
        }
        return new int[]{num1, num2};
    }
}
