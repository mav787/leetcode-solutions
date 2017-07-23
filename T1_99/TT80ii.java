package T1_99;

public class TT80ii {
	public int removeDuplicates(int[] nums) {
		   int i = 0;
		   for (int n : nums)
		      if (i < 2 || n > nums[i - 2])
		         nums[i++] = n;
		   return i;
	}
}
