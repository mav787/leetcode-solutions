package T100_199;
import java.util.*;

public class T128 {
	public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        
        for(int i : nums){
            if(set.contains(i - 1)) continue;
            int count = 0;
            while(set.contains(i)){
                count++;
                i++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
