package T500_699;
import java.util.*;
public class T645 {
	public int[] findErrorNums(int[] nums) {
        if(nums == null || nums.length == 0)
            return new int[2];
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        int max = 1;
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i]))   
                res[0] = nums[i];
            max = Math.max(max, nums[i]);
        }
        
        for(int i = 1; i <= max; i++){
            if(!set.contains(i))
                res[1] = i;
        }
        
        if(res[1] == 0)
            res[1] = max + 1;
        return res;
    }
}
