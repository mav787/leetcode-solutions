package old.T1_99;
import java.util.*;

public class TT56My {
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() < 2)
            return intervals;
        List<Interval> res = new ArrayList<>();
        int len = intervals.size();
        int[] starts = new int[len], ends = new int[len];
        for(int i = 0; i < len; i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int start = starts[0], end = ends[0];
        for(int i = 0; i < len - 1; i++){
            if(ends[i] >= starts[i + 1]){
                end = ends[i + 1];
            }
            else{
                end = ends[i];
                res.add(new Interval(start, end));
                start = starts[i + 1];
                end = ends[i + 1];
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
