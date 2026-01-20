package old.G_Salesforce.T100_999;
import java.util.*;

public class T532 {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if(k == 0){
            int res = 0;
            for(int key : map.keySet()){
                if(map.get(key) > 1){
                    res++;
                }
            }
            return res;
        }

        else{
            int res = 0;
            for(int key : map.keySet()){
                if(map.containsKey(key - k)){
                    res++;
                }
            }
            return res;
        }
    }
}
