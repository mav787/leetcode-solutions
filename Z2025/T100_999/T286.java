package Z2025.T100_999;

import java.util.*;

public class T286 {
    public void wallsAndGates(int[][] rooms) {
        // bfs
        // starting from gates

        if(rooms == null || rooms.length == 0){
            return;
        }

        Queue<Integer> queue = new LinkedList<>();  // for bfs, stores coordinates

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[i].length; j++){
                if(rooms[i][j] == 0){
                    queue.offer(i);
                    queue.offer(j);
                }
            }
        }


        while(!queue.isEmpty()){
            int i = queue.poll();
            int j = queue.poll();

            if(i - 1 >= 0 && rooms[i - 1][j] == Integer.MAX_VALUE){
                rooms[i - 1][j] = rooms[i][j] + 1;
                queue.offer(i - 1);
                queue.offer(j);
            }

            if(i + 1 < rooms.length && rooms[i + 1][j] == Integer.MAX_VALUE){
                rooms[i + 1][j] = rooms[i][j] + 1;
                queue.offer(i + 1);
                queue.offer(j);
            }

            if(j - 1 >= 0 && rooms[i][j - 1] == Integer.MAX_VALUE){
                rooms[i][j - 1] = rooms[i][j] + 1;
                queue.offer(i);
                queue.offer(j - 1);
            }

            if(j + 1 < rooms[i].length && rooms[i][j + 1] == Integer.MAX_VALUE){
                rooms[i][j + 1] = rooms[i][j] + 1;
                queue.offer(i);
                queue.offer(j + 1);
            }

        }
    }
}
