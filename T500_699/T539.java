package T500_699;
import java.util.*;

public class T539 {
	public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() < 2)
            return 0;
        int len = timePoints.size();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.split(":")[0]);
            int m = Integer.parseInt(time.split(":")[1]);
            nums[i] = 60 * h + m; 
        }
        
        Arrays.sort(nums);
        int whole = 24 * 60;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < len; i++){
            min = Math.min(nums[i] - nums[i - 1], min);
        }
        min = Math.min(min, whole + nums[0] - nums[nums.length - 1]);
        return min;
    }
}
