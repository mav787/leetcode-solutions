package old.T300_499;
import java.util.*;

public class T325 {
	public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        // key : rolling sum. value : index.
        int sum = 0;
        int res = 0;
        // dummy entry
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(!map.containsKey(sum))
                map.put(sum, i);
            if(map.containsKey(sum - k))
                res = Math.max(res, i - map.get(sum - k));
        }
        return res;
    }
}
