package Z2025.T100_999;
import java.util.*;

public class T217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if(nums == null){
            return false;
        }

        for(int num : nums){
            if(!set.add(num)){
                return true;
            }
        }

        return false;
    }
}
