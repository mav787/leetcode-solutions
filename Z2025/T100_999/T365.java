package Z2025.T100_999;

import java.util.*;

public class T365 {
    class Solution {
        public boolean canMeasureWater(int x, int y, int target) {
            if(target > x + y){
                return false;
            }

            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[x + 1][y + 1];

            queue.offer(new int[]{0, 0});
            visited[0][0] = true;

            while(!queue.isEmpty()){
                int[] curr = queue.poll();
                int a = curr[0], b = curr[1];

                if(a + b == target){
                    return true;
                }

                int pourAB = Math.min(a, y - b);
                int pourBA = Math.min(b, x - a);

                int[][] nextStates = {
                        {x, b},                    // Fill A
                        {a, y},                    // Fill B
                        {0, b},                    // Empty A
                        {a, 0},                    // Empty B
                        {a - pourAB, b + pourAB},  // Pour A -> B
                        {a + pourBA, b - pourBA}   // Pour B -> A
                };

                for(int[] next : nextStates){
                    int na = next[0], nb = next[1];

                    if(!visited[na][nb]){
                        visited[na][nb] = true;
                        queue.offer(next);
                    }
                }
            }

            return false;
        }
    }

}
