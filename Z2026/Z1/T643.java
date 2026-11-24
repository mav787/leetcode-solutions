package Z2026.Z1;

import java.util.*;

public class T643 {
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            double res = Double.NEGATIVE_INFINITY;
            int sum = 0;
            int left = 0, right = 0;

            while (right < nums.length) {
                sum += nums[right];
                right++;

                if (right - left > k) {
                    sum -= nums[left];
                    left++;
                }

                // Only evaluate a complete window of size k.
                if (right - left == k) {
                    res = Math.max(res, (double) sum / k);
                }
            }

            return res;
        }
    }

}
