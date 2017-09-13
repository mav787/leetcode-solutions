package T500_699;
import java.util.*;
public class T675 {
	class Tree {
        int x, y, h;
        Tree(int x, int y, int h) {
            this.x = x; this.y = y; this.h = h;
        }
    }
    
    public int cutOffTree(List<List<Integer>> forest) {
        Queue<Tree> pq = new PriorityQueue<>((a, b) -> a.h - b.h);
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                int val = forest.get(i).get(j);
                if (val > 1) {
                    pq.offer(new Tree(i, j, val));
                }
            }
        }
        
        int len = 0;
        Tree curr = new Tree(0, 0, forest.get(0).get(0));
        while (!pq.isEmpty()) {
            Tree next = pq.poll();
            int dist = findPath(forest, curr.x, curr.y, next.x, next.y);
            // System.out.println(next.x + "," + next.y + ":" + next.h + ", dist=" + dist);
            if (dist == -1) {
                return -1;
            } else {
                len += dist;
            }
            curr = next;
        }
        return len;
    }
    
    public int findPath(List<List<Integer>> forest, int x1, int y1, int x2, int y2) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x1, y1});
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        visited[x1][y1] = true;
        
        int pathLen = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == x2 && curr[1] == y2) {
                    return pathLen;
                }
                int val = forest.get(curr[0]).get(curr[1]);
                if (val == 0) {
                    continue;
                }
                for (int d = 0; d < dx.length; d++) {
                    int xx = curr[0] + dx[d], yy = curr[1] + dy[d];
                    if (xx >= 0 && xx < forest.size() && yy >= 0 && yy < forest.get(0).size() && !visited[xx][yy]) {
                        queue.offer(new int[]{xx, yy});
                        visited[xx][yy] = true;
                    }
                }
            }
            pathLen++;
        }
        return -1;
    }
}
