package C_Meta;
import java.util.*;
public class TTT133Opti {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        while(!queue.isEmpty()){
            UndirectedGraphNode curr = queue.poll();
            UndirectedGraphNode dup = map.get(curr);
            
            for(UndirectedGraphNode nei : curr.neighbors){
                if(!map.containsKey(nei)){
                    map.put(nei, new UndirectedGraphNode(nei.label));
                    queue.offer(nei);
                }
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
	  }