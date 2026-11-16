package Z2025.T100_999;

import java.util.*;

public class T363 {
    class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            int[][] dp = new int[m + 1][n + 1];

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + matrix[i][j];
                }
            }

            int res = Integer.MIN_VALUE;

            for(int a = 0; a < m; a++){
                for(int c = a + 1; c <= m; c++){
                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(0);

                    int curr = 0;

                    for(int j = 0; j < n; j++){
                        int colSum = dp[c][j + 1] - dp[a][j + 1]
                                - dp[c][j] + dp[a][j];

                        curr += colSum;

                        Integer prev = set.ceiling(curr - k);

                        if(prev != null){
                            res = Math.max(res, curr - prev);
                        }

                        set.add(curr);
                    }
                }
            }

            return res;
        }
    }

}
