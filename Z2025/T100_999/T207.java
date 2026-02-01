package Z2025.T100_999;
import java.util.*;

public class T207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];


        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int preq = prerequisites[i][1];

            inDegree[course]++;
            List<Integer> list = map.getOrDefault(preq, new ArrayList<>());
            list.add(course);
            map.put(preq, list);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            if(map.containsKey(course)){
                List<Integer> list = map.get(course);
                for(int next : list){
                    inDegree[next]--;
                    if(inDegree[next] == 0){
                        queue.offer(next);
                    }
                }
            }
        }

        return count == numCourses;
    }
}
