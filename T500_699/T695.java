package T500_699;

public class T695 {
	public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int count = clear(grid, i, j);
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }
    
    private int clear(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return 0;
        if(grid[i][j] == 0) return 0;
        int res = 1;
        grid[i][j] = 0;
        int up = clear(grid, i - 1, j);
        int left = clear(grid, i, j - 1);
        int down = clear(grid, i + 1, j);
        int right = clear(grid, i, j + 1);
        return res + up + left + down + right;
    }
}
