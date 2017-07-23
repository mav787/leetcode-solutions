package T200_299;
import java.util.*;

public class T219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], i);
            else{
                int j = map.get(nums[i]);
                if(i - j <= k)
                    return true;
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
