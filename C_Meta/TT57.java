package C_Meta;
import java.util.*;
public class TT57 {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0){
            if(newInterval != null) res.add(newInterval);
            return res;
        }
        intervals.add(newInterval);
        
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        
        int start = intervals.get(0).start, end = intervals.get(0).end;
        
        for(int i = 1; i < intervals.size(); i++){
            if(end < intervals.get(i).start){
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
            else{
                end = Math.max(end, intervals.get(i).end);
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
