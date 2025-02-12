package C_Meta.T1000_9999;
import java.util.*;

public class T1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid[0] == null){
            return -1;
        }
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n - 1][n - 1] != 0){
            return -1;
        }

        Queue<XNode> queue = new LinkedList<>();
        queue.offer(new XNode(0, 0));
        grid[0][0] = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                XNode node = queue.poll();
                int x = node.x, y = node.y;
                int distance = grid[x][y];
                if(x == n - 1 && y == n - 1){
                    return grid[x][y];
                }
                List<XNode> neighbors = generateNeighbors(grid, x, y);
                for(XNode neighbor : neighbors){
                    queue.offer(neighbor);
                    grid[neighbor.x][neighbor.y] = distance + 1;
                }
            }
        }
        return -1;
    }

    private List<XNode> generateNeighbors(int[][] grid, int x, int y){
        List<XNode> res = new ArrayList<>();
        int n = grid.length;
        int[] xDiff = new int[]{-1, -1, -1, 0,0,1, 1, 1};
        int[] yDiff = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        for(int i = 0; i < xDiff.length; i++){
            int newX = x + xDiff[i];
            int newY = y + yDiff[i];

            if(newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0){
                res.add(new XNode(newX, newY));
            }
        }
        return res;
    }

    class XNode{
        int x;
        int y;
        public XNode(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}


