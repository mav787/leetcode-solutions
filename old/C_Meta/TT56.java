package old.C_Meta;
import java.util.*;
public class TT56 {
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return res;
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
