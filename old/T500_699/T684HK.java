package old.T500_699;
import java.util.*;
public class T684HK {
	public int[] findRedundantConnection(int[][] edges) {
        // int[] roots = new int[n];
        Map<Integer, Integer> roots = new HashMap<>();
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            if (!roots.containsKey(node1)) roots.put(node1, node1);
            if (!roots.containsKey(node2)) roots.put(node2, node2);
            
            int root1 = find(node1, roots);
            int root2 = find(node2, roots);
            if (root1 == root2) {
                return edge;
            } else {
                roots.put(root1, root2);
            }
        }
        return new int[2];
    }
    
    private int find(int id, Map<Integer,Integer> roots) {
        if (roots.get(id) == id) return id;
        
        roots.put(id, find(roots.get(id), roots));
        return roots.get(id);
    }
}
