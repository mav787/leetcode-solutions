package T500_699;
import java.util.*;
public class T684 {
	public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0) return new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> res = new ArrayList<>();
        
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(map, edges[i][0]);
            int y = find(map, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) {
                res.add(edges[i]);
            }
            	
            // union
            map.put(x, y);
        }
        
        return res.size() == 0 ? new int[2] : res.get(res.size() - 1);
    }
    
    private int find(Map<Integer, Integer> map, int i) {
        if (!map.containsKey(i) || map.get(i) == i) 
            return i;
        return find(map, map.get(i));
    }
}
