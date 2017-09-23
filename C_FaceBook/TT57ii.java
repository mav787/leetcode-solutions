package C_FaceBook;
import java.util.*;
public class TT57ii {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    List<Interval> res = new LinkedList<>();
	    int i = 0;
	    // Step 1
	    while (i < intervals.size() && intervals.get(i).end < newInterval.start){
	    	res.add(intervals.get(i));
	    	i++;
	    }
	        
	    
	    // Step 2
	    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
	        newInterval = new Interval( // we could mutate newInterval here also
	                Math.min(newInterval.start, intervals.get(i).start),
	                Math.max(newInterval.end, intervals.get(i).end));
	        
	        i++;
	    }
	    res.add(newInterval); // add the union of intervals we got
	    
	    // Step 3
	    while (i < intervals.size()){
	    	res.add(intervals.get(i));
	    	i++;
	    }
	    return res;
	}
}
