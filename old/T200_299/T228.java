package old.T200_299;
import java.util.*;

public class T228 {
	public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            sb.append(num);
            while(i + 1 < nums.length && nums[i + 1] == nums[i] + 1){
                i = i + 1;
            }
            if(nums[i] != num){
                sb.append("->").append(nums[i]);
            }
            res.add(sb.toString());
            sb = new StringBuilder();
        }
        return res;
    }
}
