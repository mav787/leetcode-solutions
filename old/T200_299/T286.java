package old.T200_299;
import java.util.*;

public class T286 {
	public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0)
            return;
        int m = rooms.length, n = rooms[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int distance = 0;
        int inf = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    queue.offer(i);
                    queue.offer(j);
                }
            }
        }
        
        while(!queue.isEmpty()){
            int size = queue.size() / 2;
            distance++;
            for(int i = 0; i < size; i++){
                int x = queue.poll(), y = queue.poll();
                if(x - 1 >= 0 && rooms[x - 1][y] == inf){
                    rooms[x - 1][y] = distance;
                    queue.offer(x - 1);
                    queue.offer(y);
                }
                if(x + 1 < m && rooms[x + 1][y] == inf){
                    rooms[x + 1][y] = distance;
                    queue.offer(x + 1);
                    queue.offer(y);
                }
                if(y - 1 >= 0 && rooms[x][y - 1] == inf){
                    rooms[x][y - 1] = distance;
                    queue.offer(x);
                    queue.offer(y - 1);
                }
                if(y + 1 < n && rooms[x][y + 1] == inf){
                    rooms[x][y + 1] = distance;
                    queue.offer(x);
                    queue.offer(y + 1);
                }
            }
            
        }
    }
}
