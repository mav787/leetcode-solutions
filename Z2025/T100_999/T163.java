package Z2025.T100_999;
import java.util.*;

public class T163 {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        int low = lower;

        for(int num : nums){
            if(num > low){
                List<Integer> range = new ArrayList<>();
                range.add(low);
                range.add(num - 1);
                res.add(range);
            }

            low = num + 1;
        }

        if(low <= upper){
            List<Integer> range = new ArrayList<>();
            range.add(low);
            range.add(upper);
            res.add(range);
        }

        return res;
    }
}
