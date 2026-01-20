package old.G_Salesforce.T100_999;
import java.util.*;

public class T210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> outEdges = new HashMap<>();

        // 1. construct inDegree and outEdges
        for(int i = 0; i < prerequisites.length; i++){
            int a = prerequisites[i][0], b = prerequisites[i][1];

            // b -> a
            inDegree[a]++;
            List<Integer> edges = outEdges.getOrDefault(b, new ArrayList<>());
            edges.add(a);
            outEdges.put(b, edges);
        }

        // 2. put everything with inDegree == 0 into queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        // 3. BFS
        int[] res = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()){
            int course = queue.poll();
            res[index] = course;
            index++;

            if(outEdges.containsKey(course)){
                for(int other : outEdges.get(course)){
                    inDegree[other]--;
                    if(inDegree[other] == 0){
                        queue.offer(other);
                    }
                }
            }
        }

        // 4. return
        return index == numCourses ? res : new int[0];
    }
}
