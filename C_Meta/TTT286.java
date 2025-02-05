package C_Meta;
import java.util.*;

public class TTT286 {
	public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) 
            return;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(i);
                    queue.offer(j);
                }
                    
            }
        }
        while (!queue.isEmpty()) {
            int row = queue.poll();
            int col = queue.poll();
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {          // empty room
                rooms[row - 1][col] = rooms[row][col] + 1;                      // mark value
                queue.offer(row - 1);
                queue.offer(col);
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;                      // mark value
                queue.offer(row + 1);
                queue.offer(col);
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;                      // mark value
                queue.offer(row);
                queue.offer(col - 1);
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;                      // mark value
                queue.offer(row);
                queue.offer(col + 1);
            }
        }
    }
}
