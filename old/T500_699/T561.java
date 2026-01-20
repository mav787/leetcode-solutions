package old.T500_699;
import java.util.*;
public class T561 {
	public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length % 2 != 0)
            return -1;
        int n = nums.length / 2;
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < n; i++){
            res += nums[2 * i];
        }
        return res;
    }
}
