package Z2025.T100_999;

import java.util.*;

public class T303 {
    class NumArray {
        int[] prefixSum;

        public NumArray(int[] nums) {
            int n = nums.length;
            prefixSum = new int[n + 1];
            int sum = 0;

            for(int i = 0; i < n; i++){
                sum += nums[i];
                prefixSum[i + 1] = sum;
            }
        }

        public int sumRange(int left, int right) {
            return prefixSum[right + 1] - prefixSum[left];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}
