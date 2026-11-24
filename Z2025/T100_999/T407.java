package Z2025.T100_999;

import java.util.*;

public class T407 {

    class Solution {
        public int trapRainWater(int[][] heightMap) {
            int m = heightMap.length;
            int n = heightMap[0].length;

            boolean[][] visited = new boolean[m][n];

            // Min heap: {row, col, effectiveHeight}
            Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

            // Initialize the heap with all boundary cells.
            for (int i = 0; i < m; i++) {
                heap.offer(new int[]{i, 0, heightMap[i][0]});
                heap.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
                visited[i][0] = true;
                visited[i][n - 1] = true;
            }

            for (int j = 1; j < n - 1; j++) {
                heap.offer(new int[]{0, j, heightMap[0][j]});
                heap.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
                visited[0][j] = true;
                visited[m - 1][j] = true;
            }

            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int res = 0;

            while (!heap.isEmpty()) {
                // Always expand from the lowest effective boundary.
                int[] curr = heap.poll();
                int row = curr[0];
                int col = curr[1];
                int height = curr[2];

                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Skip if illegal or visited
                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]) {
                        continue;
                    }

                    visited[newRow][newCol] = true;

                    // Trap water if the neighbor is below the boundary.
                    res += Math.max(0, height - heightMap[newRow][newCol]);

                    // Maintain the effective water level.
                    int nextHeight = Math.max(height, heightMap[newRow][newCol]);
                    heap.offer(new int[]{newRow, newCol, nextHeight});
                }
            }

            return res;
        }
    }

}
