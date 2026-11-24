package Z2025.T100_999;

import java.util.*;

public class T396 {
    class Solution {
        public int maxRotateFunction(int[] nums) {
            long ref = 0;
            long sum = 0;
            int n = nums.length;

            for(int i = 0; i < nums.length; i++){
                sum += nums[i];
                ref += i * nums[i];
            }


            // ref: 0[0] 1[1] 2[2] 3[3] ... n-1[n-1]
            // curr: 1[0] 2[1] 3[2] 4[3] ... n-1[n-2] 0[n-1]

            long res = ref;

            for(int i = 0; i < nums.length - 1; i++){
                long curr = ref + sum - n * nums[nums.length - 1 - i];
                ref = curr;
                res = Math.max(res, curr);
            }

            return (int)res;
        }
    }
}
