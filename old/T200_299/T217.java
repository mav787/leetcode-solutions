package old.T200_299;
import java.util.*;

public class T217 {
	public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length < 2) return false;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
