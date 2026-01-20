package old.T200_299;

public class T200 {
	public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    res += 1;
                    clearNeighbors(grid, i, j);
                }
            }
        }
        return res;
    }
    
    private void clearNeighbors(char[][] grid, int i, int j){
        grid[i][j] = '0';
        if(i - 1 >= 0 && grid[i - 1][j] == '1')
            clearNeighbors(grid, i - 1, j);
        if(i + 1 < grid.length && grid[i + 1][j] == '1')
            clearNeighbors(grid, i + 1, j);
        if(j - 1 >= 0 && grid[i][j - 1] == '1')
            clearNeighbors(grid, i, j - 1);
        if(j + 1 < grid[0].length && grid[i][j + 1] == '1')
            clearNeighbors(grid, i, j + 1);
    }
}
