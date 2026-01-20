package old.T500_699;
import java.util.*;

public class T542 {
	public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int m = matrix.size(); 
        int n = matrix.get(0).size(); 
        if(m == 0 || n == 0)
            return new ArrayList<>();
        int[][] ans=new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == 0) {
                    ans[i][j] = 0;
                    queue.offer(i);
                    queue.offer(j);
                }
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll(), y = queue.poll();
            int d = ans[x][y];
            int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir: dirs) {
                int newx = x + dir[0], newy = y + dir[1];
                if (newx >= 0 && newx < m && newy >=0 && newy < n) {
                	if(d + 1 < ans[newx][newy]){
                        ans[newx][newy] = d + 1;
                        queue.offer(newx);
                        queue.offer(newy);
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < ans.length; i++){
            List<Integer> row = new ArrayList<>();
            res.add(row);
            for(int j = 0; j < ans[0].length; j++){
                row.add(ans[i][j]);
            }
        }
        return res;
    }
}
