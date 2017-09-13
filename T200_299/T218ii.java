package T200_299;
import java.util.*;

public class T218ii {
	public List<int[]> getSkyline(int[][] buildings) {
	    	if (buildings.length == 0)
	    		return new LinkedList<int[]>();
	    	return recurSkyline(buildings, 0, buildings.length - 1);
    }
    
    private LinkedList<int[]> recurSkyline(int[][] buildings, int left, int right) {
	    	if (left < right) {
	    		int mid = left + (right - left) / 2;
	    		return merge(recurSkyline(buildings, left, mid),
	    				recurSkyline(buildings, mid + 1, right));
	    	} else {
	    		LinkedList<int[]> rs = new LinkedList<int[]>();
	    		rs.add(new int[] { buildings[left][0], buildings[left][2] });
	    		rs.add(new int[] { buildings[left][1], 0 });
	    		return rs;
	    	}
    }
    
    private LinkedList<int[]> merge(LinkedList<int[]> l1, LinkedList<int[]> l2) {
	    	LinkedList<int[]> rs = new LinkedList<int[]>();
	    	int h1 = 0, h2 = 0;
	    	while (l1.size() > 0 && l2.size() > 0) {
	    		int x = 0, h = 0;
	    		if (l1.getFirst()[0] < l2.getFirst()[0]) {
	    			x = l1.getFirst()[0];
	    			h1 = l1.getFirst()[1];
	    			h = Math.max(h1, h2);
	    			l1.removeFirst();
	    		} else if (l1.getFirst()[0] > l2.getFirst()[0]) {
	    			x = l2.getFirst()[0];
	    			h2 = l2.getFirst()[1];
	    			h = Math.max(h1, h2);
	    			l2.removeFirst();
	    		} else {
	    			x = l1.getFirst()[0];
	    			h1 = l1.getFirst()[1];
	    			h2 = l2.getFirst()[1];
	    			h = Math.max(h1, h2);
	    			l1.removeFirst();
	    			l2.removeFirst();
	    		}
	    		if (rs.size() == 0 || h != rs.getLast()[1]) {
	    			rs.add(new int[] { x, h });
	    		}
	    	}
	    	rs.addAll(l1);
	    	rs.addAll(l2);
	    	return rs;
    }
}
