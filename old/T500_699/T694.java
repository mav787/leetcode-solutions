package old.T500_699;
import java.util.*;
public class T694 {
	public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    List<Integer> list = new ArrayList<>();
                    clear(grid, i, j, list, 0, 0);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    
    private void clear(int[][] grid, int i, int j, List<Integer> list, int rx, int ry){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return;
        if(grid[i][j] == 0) return;
        grid[i][j] = 0;
        list.add(rx);
        list.add(ry);
        clear(grid, i - 1, j, list, rx-1, ry);
        clear(grid, i + 1, j, list, rx + 1, ry);
        clear(grid, i, j - 1, list, rx, ry -1);
        clear(grid, i, j + 1, list, rx, ry + 1);
        
    }
}
