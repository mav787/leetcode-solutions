package T1_99;
import java.util.*;

public class TT57my {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        int[] starts = new int[intervals.size() + 1];
        int[] ends = new int[intervals.size() + 1];
        insertStart(starts, intervals, newInterval);
        insertEnd(ends, intervals, newInterval);
        int mark = 0;
        for(int i = 0; i < starts.length - 1; i++){
            if(ends[i] >= starts[i + 1]){
                continue;
            }
            else{
                res.add(new Interval(starts[mark], ends[i]));
                mark = i + 1;
            }
        }
        res.add(new Interval(starts[mark], ends[ends.length - 1]));
        return res;
    }
    
    private void insertStart(int[] starts, List<Interval> intervals, Interval newInterval){
        int newcount = 0, oricount = 0, curr = 0;
        while(oricount < intervals.size() && newcount < 1){
            Interval interval = intervals.get(oricount);
            if(interval.start <= newInterval.start){
                starts[curr++] = interval.start;
                oricount++;
            }
            else{
                starts[curr++] = newInterval.start;
                newcount++;
            }
        }
        
        while(oricount < intervals.size()){
            starts[curr++] = intervals.get(oricount++).start;
        }
        while(newcount < 1){
            starts[curr++] = newInterval.start;
            newcount++;
        }
    }
    
    private void insertEnd(int[] ends, List<Interval> intervals, Interval newInterval){
        int newcount = 0, oricount = 0, curr = 0;
        while(oricount < intervals.size() && newcount < 1){
            Interval interval = intervals.get(oricount);
            if(interval.end <= newInterval.end){
                ends[curr++] = interval.end;
                oricount++;
            }
            else{
                ends[curr++] = newInterval.end;
                newcount++;
            }
        }
        
        while(oricount < intervals.size()){
            ends[curr++] = intervals.get(oricount++).end;
        }
        while(newcount < 1){
            ends[curr++] = newInterval.end;
            newcount++;
        }
    }
}
