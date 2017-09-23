package C_FaceBook;
import java.util.*;

public class A1 {
	public int[] minMax(int[] nums){
	    if(nums == null || nums.length == 0) return new int[2];

	    int low = 0, high = nums.length - 1;
	    return minMax(nums, low, high); 

	}

	private int[] minMax(int[] nums, int low, int high){
		int[] res = new int[2];
	    if(low == high){
	        return new int[]{nums[low], nums[high]};
	    }
	    else if(low + 1 == high){
	        res[0] = Math.min(nums[low], nums[high]);
	        res[1] = Math.max(nums[low], nums[high]);
	        return res;
	    }else{
	        int mid = low + (high - low) / 2;          
	        int[] left = minMax(nums, low, mid);
	        int[] right = minMax(nums, mid + 1, high);
	        
	        res[0] = Math.min(left[0], right[0]);
	        res[1] = Math.max(left[1], right[1]);             
	        return res;
	    }

	}

	public static void main(String[] args) {

	    int[] array = {1,2,3,4,100};
	    A1 obj = new A1();
	    System.out.println("min and max values are "+ Arrays.toString(obj.minMax(array)));
	}
}
