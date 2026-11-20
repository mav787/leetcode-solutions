package Z2025.T100_999;

import java.util.*;

public class T386 {
    public class Solution {

        public List<Integer> lexicalOrder(int n) {
            List<Integer> res = new ArrayList<>();
            // i generating numbers from 1 to 9
            for (int i = 1; i <= 9; i++) {
                helper(i, n, res);
            }
            return res;
        }

        private void helper(int i, int n, List<Integer> res) {
            // If the current number exceeds the n, stop recursion
            if (i > n) {
                return;
            }

            // Add the current number to the res
            res.add(i);

            // Try to append digits from 0 to 9 to the current number
            for (int j = 0; j <= 9; j++) {
                int next = i * 10 + j;
                // If the next number is within the n, continue recursion
                if (next <= n) {
                    helper(next, n, res);
                } else {
                    break; // No need to continue if next exceeds n
                }
            }
        }
    }
}
