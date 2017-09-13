package T500_699;
import java.util.*;
public class T675My {
	public int cutOffTree(List<List<Integer>> forest) {
        if(forest == null) return 0;
        int m = forest.size(), n = forest.get(0).size();
        Map<Integer, int[]> map = new HashMap<>();
        Queue<Integer> heap = new PriorityQueue<>();
        int[][] board = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = forest.get(i).get(j);
                if(board[i][j] > 1){
                    map.put(board[i][j], new int[]{i, j});
                    heap.offer(board[i][j]);
                }
            }
        }
        
        int res = 0;
        int currx = 0, curry = 0;
        while(!heap.isEmpty()){
            int[] next = map.get(heap.poll());
            int dist = computeDist(board, currx, curry, next);
            if(dist == -1) return -1;
            res += dist;
            currx = next[0];
            curry = next[1];
            // board[currx][curry] = 1;
        }
        return res;
    }
    
	private int computeDist(int[][] board, int x, int y, int[] next){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        boolean[][] visited = new boolean[board.length][board[0].length];
        visited[x][y] = true;
        
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == next[0] && curr[1] == next[1]) {
                    return dist;
                }
                for (int d = 0; d < dx.length; d++) {
                    int xx = curr[0] + dx[d], yy = curr[1] + dy[d];
                    if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length 
                            && !visited[xx][yy] && board[xx][yy] != 0) {
                        queue.offer(new int[]{xx, yy});
                        visited[xx][yy] = true;
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}
