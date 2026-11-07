package Z2025.T100_999;

import java.util.*;

public class T327 {
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            long[] prefix = new long[nums.length + 1];

            for (int i = 0; i < nums.length; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }

            return mergeSort(prefix, 0, prefix.length, lower, upper);
        }

        private int mergeSort(long[] sum, int left, int right,
                              int lower, int upper) {
            if (right - left <= 1) return 0;

            int mid = left + (right - left) / 2;
            int count = mergeSort(sum, left, mid, lower, upper)
                    + mergeSort(sum, mid, right, lower, upper);

            int j = mid, k = mid, t = mid;
            long[] temp = new long[right - left];
            int r = 0;

            for (int i = left; i < mid; i++) {
                while (k < right && sum[k] - sum[i] < lower) k++;
                while (j < right && sum[j] - sum[i] <= upper) j++;
                count += j - k;

                while (t < right && sum[t] < sum[i]) {
                    temp[r++] = sum[t++];
                }

                temp[r++] = sum[i];
            }

            while (t < right) temp[r++] = sum[t++];

            System.arraycopy(temp, 0, sum, left, r);

            return count;
        }
    }

}
