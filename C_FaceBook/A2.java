package C_FaceBook;

import java.util.Arrays;

public class A2 {
	public int[] minmax2(int[] nums) {
		if (nums == null || nums.length < 1) return new int[0];
	 
		// if only one element
		if (nums.length == 1) return new int[]{nums[0], nums[0]};
		
		// initialize
		int min = nums[0], max = nums[0];
		if (nums[0] > nums[1]) {
			min = nums[1];
			max = nums[0];
		} else {
			min = nums[0];
			max = nums[1];
		}
	 
		for (int i = 2; i < nums.length - 1; i = i + 2) {
			if (nums[i] < nums[i + 1]) {
				min = Math.min(min, nums[i]);
				max = Math.max(max, nums[i + 1]);
			} else {
				min = Math.min(min, nums[i + 1]);
				max = Math.max(max, nums[i]);
			}
		}
	 
		if (nums.length % 2 == 1) {
			min = Math.min(min, nums[nums.length - 1]);
			max = Math.max(max, nums[nums.length - 1]);
		}
	 
		return new int[]{min, max};
	}
	
	public static void main(String[] args) {

	    int[] array = {1,2,3,4,100};
	    A2 obj = new A2();
	    System.out.println("min and max values are "+ Arrays.toString(obj.minmax2(array)));
	}
}
