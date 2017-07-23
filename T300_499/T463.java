package T300_499;

public class T463 {
	public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int block = 0, neighbor = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 1){
                    block++;
                    if(i != 0 && grid[i - 1][j] == 1){
                        neighbor++;
                    }
                    if(j != 0 && grid[i][j - 1] == 1){
                        neighbor++;
                    }
                }
            }
        }
        return block * 4 - neighbor * 2;
    }
}
