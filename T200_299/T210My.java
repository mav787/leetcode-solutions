package T200_299;
import java.util.*;

public class T210My {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0 || prerequisites == null)    return new int[0];
        int[] res = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        
        // Construct the graph (neighbors)
        for(int i = 0; i < prerequisites.length; i++){
            if(!map.containsKey(prerequisites[i][1])) {
                map.put(prerequisites[i][1], new ArrayList<Integer>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        
        int curr = 0;
        // initialize Topological Sort
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                visited[i] = true;
                res[curr] = i;
                curr++;
            }
        }
        
        // Topo Sorting
        while(!queue.isEmpty()){
            int course = queue.poll();
            if(!map.containsKey(course)) continue;          // some may be independent...
            List<Integer> neighbors = map.get(course);
            for(int i = 0; i < neighbors.size(); i++){
                int neighbor = neighbors.get(i);
                if(visited[neighbor]) continue;
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                    res[curr++] = neighbor;
                }
            }
        }
        
        if(curr == numCourses)
            return res;
        return new int[0];
    }
}
