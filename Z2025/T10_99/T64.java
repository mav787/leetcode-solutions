package Z2025.T10_99;

public class T64 {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return Integer.MAX_VALUE;
        }

        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        int sum = 0;
        for(int i = 0; i < m; i++){
            sum += grid[i][0];
            dp[i][0] = sum;
        }

        sum = 0;
        for(int j = 0; j < n; j++){
            sum += grid[0][j];
            dp[0][j] = sum;
        }


        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}
