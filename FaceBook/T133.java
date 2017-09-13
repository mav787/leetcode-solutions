package FaceBook;
import java.util.*;
public class T133 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode curr = queue.poll();
            map.put(curr, new UndirectedGraphNode(curr.label));
            for(UndirectedGraphNode nei : curr.neighbors){
                if(!map.containsKey(nei)){
                    queue.offer(nei);
                }
            }
        }
        
       for(UndirectedGraphNode item : map.keySet()){
            UndirectedGraphNode dup = map.get(item);
            for(UndirectedGraphNode nei: item.neighbors){
                dup.neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }
}

class UndirectedGraphNode {
	      int label;
	      List<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	  };