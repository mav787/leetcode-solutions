package FaceBook;

import java.util.*;

import T200_299.Interval;

public class TT56 {
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0)
            return res;
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        for(int i = 0; i < intervals.size(); i++){
            Interval interval = intervals.get(i);
            starts[i] = interval.start;
            ends[i] = interval.end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int mark = 0;
        for(int i = 0; i < starts.length - 1; i++){
            if(starts[i + 1] <= ends[i])
                continue;
            else{
                res.add(new Interval(starts[mark], ends[i]));
                mark = i + 1;
            }
        }
        res.add(new Interval(starts[mark], ends[ends.length - 1]));
        return res;
    }
}


  