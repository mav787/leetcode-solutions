package FaceBook;
import java.util.*;

public class TTT210My {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || numCourses <= 0) return new int[0];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
            int prior = prerequisites[i][1];
            if(!map.containsKey(prior)){
                map.put(prior, new ArrayList<Integer>());
            }
            
            map.get(prior).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        int curr = 0;
        
        while(!queue.isEmpty()){
            int prior = queue.poll();
            res[curr] = prior;
            curr++;
            if(map.containsKey(prior)){
                for(int next : map.get(prior)){
                    indegree[next]--;
                    if(indegree[next] == 0){
                        queue.offer(next);
                    }
                }
            }
        }
        return curr == numCourses ? res : new int[0];
    }
}
