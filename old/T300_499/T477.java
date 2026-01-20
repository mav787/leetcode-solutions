package old.T300_499;

public class T477 {
	public int totalHammingDistance(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;
        int total = 0, n = nums.length;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int j = 0 ; j < n; j++) 
                bitCount += (nums[j] >> i) & 1;
            total += bitCount * (n - bitCount);
        }
        return total;
    }
}
