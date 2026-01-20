package old.T200_299;
import java.util.*;
public class T296 {
	public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int res = 0;
        int m = grid.length, n = grid[0].length;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        Collections.sort(row);
        Collections.sort(col);
        
        int left = 0, right = row.size() - 1;
        while(left < right){
            res += row.get(right) - row.get(left);
            left++;
            right--;
        }
        
        int up = 0, down = col.size() - 1;
        while(up < down){
            res += col.get(down) - col.get(up);
            up++;
            down--;
        }
        return res;
    }
}
