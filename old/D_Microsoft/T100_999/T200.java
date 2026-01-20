package old.D_Microsoft.T100_999;

public class T200 {
    public int numIslands(char[][] grid) {
        if(grid == null || grid[0] == null) return 0;
        int m = grid.length, n = grid[0].length;
        int res = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    res++;
                    reset(grid, i, j, m, n);
                }
            }
        }
        return res;
    }

    private void reset(char[][] grid, int i, int j, int m, int n){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        reset(grid, i - 1, j, m, n);
        reset(grid, i, j - 1, m, n);
        reset(grid, i + 1, j, m, n);
        reset(grid, i, j + 1, m, n);
    }
}
