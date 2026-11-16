package Z2025.T100_999;

import java.util.*;

public class T361 {
    class Solution {
        public int maxKilledEnemies(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] rows = new int[m][n];
            int[][] cols = new int[m][n];

            for(int i = 0; i < m; i++){
                calcRows(grid, rows, i);
            }

            for(int j = 0; j < n; j++){
                calcCols(grid, cols, j);
            }

            int res = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '0'){
                        res = Math.max(res, rows[i][j] + cols[i][j]);
                    }
                }
            }

            return res;
        }

        private void calcRows(char[][] grid, int[][] rows, int i){
            int count = 0;
            int j = 0;
            int prev = j;

            while(j < grid[i].length){
                if(grid[i][j] == 'E'){
                    count++;
                    j++;
                }
                else if(grid[i][j] == 'W'){
                    for(int k = prev; k < j; k++){
                        rows[i][k] = count;
                    }
                    count = 0;
                    j++;
                    prev = j;
                }
                else{
                    j++;
                }
            }

            for(int k = prev; k < grid[i].length; k++){
                rows[i][k] = count;
            }
        }

        private void calcCols(char[][] grid, int[][] cols, int j){
            int count = 0;
            int i = 0;
            int prev = i;

            while(i < grid.length){
                if(grid[i][j] == 'E'){
                    count++;
                    i++;
                }
                else if(grid[i][j] == 'W'){
                    for(int k = prev; k < i; k++){
                        cols[k][j] = count;
                    }
                    count = 0;
                    i++;
                    prev = i;
                }
                else{
                    i++;
                }
            }

            for(int k = prev; k < grid.length; k++){
                cols[k][j] = count;
            }
        }
    }

}
