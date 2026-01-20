package old.C_Meta;
import java.util.*;
public class TTT218 {
	public List<int[]> getSkyline(int[][] buildings) {
	    List<int[]> res = new ArrayList<>();
	    List<int[]> height = new ArrayList<>();
	    for(int[] b : buildings) {
	        height.add(new int[]{b[0], -b[2]});
	        height.add(new int[]{b[1], b[2]});
	    }
	    Collections.sort(height, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
	    
	    Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
	    heap.offer(0);
	    int prev = 0;
	    for(int[] h : height) {
	        if(h[1] < 0) {
	            heap.offer(-h[1]);
	        } else {
	            heap.remove(h[1]);
	        }
	        int curr = heap.peek();
	        if(prev != curr) {
	            res.add(new int[]{h[0], curr});		// x, y
	            prev = curr;
	        }
	    }
	    return res;
	}
}
