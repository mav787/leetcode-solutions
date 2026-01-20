package Z2025.T10_99;

public class T63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] grid = obstacleGrid;
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            if(grid[i][0] == 0){
                dp[i][0] = 1;
            }
            else{
                break;
            }
        }

        for(int j = 0; j < n; j++){
            if(grid[0][j] == 0){
                dp[0][j] = 1;
            }
            else{
                break;
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = grid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
