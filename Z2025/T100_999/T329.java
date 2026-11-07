package Z2025.T100_999;

import java.util.*;

public class T329 {
    // helper + Memoization Solution
// Accepted and Recommended
    public class Solution {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix.length == 0) {
                return 0;
            }

            int m = matrix.length, n = matrix[0].length;
            int[][] memo = new int[m][n];
            int res = 0;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    res = Math.max(res, helper(matrix, i, j, m, n, memo));
                }
            }
            return res;
        }

        private int helper(int[][] matrix, int x, int y, int m, int n, int[][] memo) {
            if (memo[x][y] != 0) {
                return memo[x][y];
            }

            int res = 1;
            for(int i = 0; i < dirs.length; i++){
                int newX = x + dirs[i][0];
                int newY = y + dirs[i][1];

                if(newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] > matrix[x][y]){
                    res = Math.max(res, 1 + helper(matrix, newX, newY, m, n, memo));
                }
            }

            memo[x][y] = res;
            return res;
        }
    }
}
