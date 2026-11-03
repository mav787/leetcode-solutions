package Z2025.Z_Tree;

import java.util.*;

public class T582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ;i < pid.size(); i++){
            int process = pid.get(i);
            int parent = ppid.get(i);

            List<Integer> children = map.getOrDefault(parent, new ArrayList<>());
            children.add(process);
            map.put(parent, children);
        }

        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);

        while(!queue.isEmpty()){
            int curr = queue.poll();
            set.add(curr);
            if(map.containsKey(curr)){
                for(int child : map.get(curr)){
                    if(!set.contains(child)){
                        queue.offer(child);
                    }
                }
            }
        }

        return new ArrayList<>(set);

    }

}
