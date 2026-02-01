package Z2025.T100_999;
import java.util.*;

public class T210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        if(n <= 0){
            return new int[0];
        }


        int[] res = new int[n];
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int preq = prerequisites[i][1];

            inDegree[course]++;
            List<Integer> list = map.getOrDefault(preq, new ArrayList<>());
            list.add(course);
            map.put(preq, list);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int index = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            res[index] = course;
            index++;

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

        return index == n ? res : new int[0];
    }
}
