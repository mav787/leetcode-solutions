package Z2025.T100_999;

import java.util.*;

public class T378 {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            Queue<int[]> heap = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);

            for(int i = 0; i < Math.min(m, k); i++){
                heap.offer(new int[]{i, 0});
            }

            int res = 0;
            while(k > 0 && !heap.isEmpty()){
                int[] curr = heap.poll();
                int x = curr[0], y = curr[1];

                res = matrix[x][y];
                if(y + 1 < n){
                    heap.offer(new int[]{x, y + 1});
                }

                k--;
            }

            return res;
        }
    }

}
