package Z2025.T100_999;

import java.util.*;

public class T560 {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int sum = 0;


        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int res = 0;

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
