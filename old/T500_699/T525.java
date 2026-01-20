package old.T500_699;
import java.util.*;
public class T525 {
	public int findMaxLength(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                sum--;
            }
            else{
                sum++;
            }
            
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            else{
                res = Math.max(res, i - map.get(sum));    
            }
        }
        return res;
    }
}
