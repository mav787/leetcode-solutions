package FaceBook;
import java.util.*;
public class TT56ii {
	public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;
        
        // Sort by ascending starting point using an anonymous Comparator
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        
        List<Interval> res = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        
        // Add the last interval
        res.add(new Interval(start, end));
        return res;
    }
}
