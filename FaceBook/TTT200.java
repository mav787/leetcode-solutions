package FaceBook;

public class TTT200 {
	public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    res++;
                    clearNeighbors(grid, i, j, m, n);
                }
            }
        }
        return res;
    }
    
    private void clearNeighbors(char[][] grid, int i, int j, int m, int n){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return;
        }
        if(grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        clearNeighbors(grid, i - 1, j, m, n);
        clearNeighbors(grid, i + 1, j, m, n);
        clearNeighbors(grid, i, j - 1, m, n);
        clearNeighbors(grid, i, j + 1, m, n);
    }
}
