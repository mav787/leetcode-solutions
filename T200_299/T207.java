package T200_299;
import java.util.*;

public class T207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for(int i = 0; i < prerequisites.length; i++){
                if(prerequisites[i][1] == course){
                    indegree[prerequisites[i][0]]--;
                    if(indegree[prerequisites[i][0]] == 0)
                        queue.offer(prerequisites[i][0]);
                }
            }
        }
        return count == numCourses;
    }
}
