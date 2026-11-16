package Z2025.T100_999;

import java.util.*;

public class T370 {
    class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            // diff[i] represents the change starting at index i
            int[] diff = new int[length];

            for(int[] update : updates){
                int start = update[0];
                int end = update[1];
                int inc = update[2];

                // Start adding inc at index start
                diff[start] += inc;

                // Stop adding inc after index end
                if(end + 1 < length){
                    diff[end + 1] -= inc;
                }
            }

            int prefixSum = 0;
            // Prefix sum: reconstruct the final array
            for(int i = 0; i < length; i++){
                prefixSum += diff[i];
                diff[i] = prefixSum;
            }

            return diff;
        }
    }

}
