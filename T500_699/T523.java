package T500_699;
import java.util.*;

public class T523 {
	public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return false;
        if(k < 0){
            k = -k;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(k != 0){
                sum %= k;
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            else{
                if(i - map.get(sum) > 1) return true;
            }
        }
        return false;
    }
}
