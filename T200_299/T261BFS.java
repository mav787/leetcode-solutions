package T200_299;
import java.util.*;

public class T261BFS {
	public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(i, new HashSet<>());
        }
        
        for(int i = 0; i < edges.length; i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            Set<Integer> neighbor = map.get(curr);
            for(int i : neighbor){
                if(visited[i])
                    return false;
                queue.offer(i);
                visited[i] = true;
                map.get(i).remove(curr);
            }
        }
        for(boolean b : visited){
            if(b == false)
                return false;
        }
        return true;
    }
}
