package C_Meta.T100_999;
import java.util.*;

public class T560 {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        // 1. construct the rolling sum
        // 2. iterate through the rolling sum, construct a hashmap
        // 2.1  {rollingsum -> # of subarrays that has this rollingsum} (frequency, cardinality)
        // 2.2  look up from map, using rollingsum - k, if match, add the value/frequency to the result
        // 3. construct hashmap

        Map<Integer, Integer> map = new HashMap<>();

        // VERY IMPORTANT. SUPPOSE SUBARRAY STARTS AT INDEX 0.
        map.put(0, 1);

        int res = 0;

        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            if(map.containsKey(sum - k)){
                res += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
