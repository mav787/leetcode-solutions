package G_Salesforce.T1000_9999;
import java.util.*;

public class T2964 {
    public int divisibleTripletCount(int[] nums, int d) {
        int res = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int key = (nums[i] + nums[j]) % d;
                if(!map.containsKey(key)){
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(new int[]{i, j});
            }
        }
        for(int k = 0; k < nums.length; k++){
            int key = (d - nums[k] % d) % d;
            if(map.containsKey(key)){
                for(int[] index : map.get(key)){
                    // make sure order is valid: i < j < k
                    if(index[0] > k){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
