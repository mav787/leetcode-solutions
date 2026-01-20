package old.T100_199;
import java.util.*;
public class T133 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode item = queue.poll();
            map.put(item, new UndirectedGraphNode(item.label));
            for(UndirectedGraphNode neighbor: item.neighbors){
                if(!map.containsKey(neighbor)){
                    queue.offer(neighbor);
                }
            }
        }
        
        for(UndirectedGraphNode item : map.keySet()){
            UndirectedGraphNode dup = map.get(item);
            for(UndirectedGraphNode neighbor: item.neighbors){
                dup.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
