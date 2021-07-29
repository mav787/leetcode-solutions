package T1_99;
import java.util.*;

public class TT57ans {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    if(intervals == null || newInterval == null){
	        return intervals;
	    }
	    List<Interval> result = new LinkedList<>();
	    int i = 0;
	    // add all the intervals ending before newInterval starts
	    while (i < intervals.size() && intervals.get(i).end < newInterval.start){
                result.add(intervals.get(i));
                i++;
            }
	        
	    // merge all overlapping intervals to one considering newInterval
	    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
	        Interval curr = intervals.get(i);
                int lower = Math.min(newInterval.start, curr.start);
                int upper = Math.max(newInterval.end, curr.end);
                newInterval = new Interval(lower, upper);
	        i++;
	    }
	    result.add(newInterval); // add the union of intervals we got
	    // add all the rest
	    while (i < intervals.size()) {
                result.add(intervals.get(i));
                i++;
            }
	    return result;
	}
}
