package T100_199;
import java.util.*;

public class T163 {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if(nums == null)
            return result;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == Integer.MIN_VALUE) {
                lower = num + 1;
                continue;
            }
            int justBelow = num - 1;
            if (justBelow == lower) 
                result.add(lower + "");
            else if (lower < justBelow) 
                result.add(lower + "->" + justBelow);
            
            if (num == upper) 
                return result;
            else 
                lower = num + 1;
        }
        
        if (lower == upper) 
            result.add(lower + "");
        else if (lower < upper) 
            result.add(lower + "->" + upper);
        
        return result;
    }
}
