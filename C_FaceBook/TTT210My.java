package C_FaceBook;
import java.util.*;

public class TTT210My {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if(prerequisites == null || prerequisites.length == 0){
            for(int i = 0; i < res.length; i++){
                res[i] = i;
            }
            return res;
        }
        
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < prerequisites.length; i++){
            if(prerequisites[i].length != 2) return res;
            int first = prerequisites[i][1];
            int second = prerequisites[i][0];
            
            if(!map.containsKey(first)){
                map.put(first, new ArrayList<Integer>());
            }
            map.get(first).add(second);
            indegree[second]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        int curr = 0;
        while(!queue.isEmpty()){
            int first = queue.poll();
            res[curr] = first;
            curr++;
            
            if(map.containsKey(first)){
                List<Integer> neighbors = map.get(first);
                for(Integer second : neighbors){
                    indegree[second]--;
                    if(indegree[second] == 0){
                        queue.offer(second);
                    }
                }
            }
        }
        return curr == numCourses ? res : new int[0];
    }
}
