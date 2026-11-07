package Z2025.T100_999;

import java.util.*;

public class T325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i = 0; i < n; i++){
            sum += nums[i];
            int target = sum - k;

            if(map.containsKey(target)){
                res = Math.max(res, i - map.get(target));
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        return res;
    }
}
