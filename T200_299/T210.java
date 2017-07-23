package T200_299;
import java.util.*;

public class T210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) { 
        if (numCourses == 0) 
            return null;

        int[] indegree = new int[numCourses], res = new int[numCourses];
        int index = 0;
        for (int i = 0; i < prerequisites.length; i++) 
            indegree[prerequisites[i][0]]++;    
    
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) 
            if (indegree[i] == 0) {
                res[index++] = i;
                queue.offer(i);
            }
    
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); 
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--; 
                    if (indegree[prerequisites[i][0]] == 0) {
                        res[index++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);
                    }
                } 
            }
        }
    
        return (index == numCourses) ? res : new int[0];
    }
}
