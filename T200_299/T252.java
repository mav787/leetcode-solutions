package T200_299;
import java.util.*;

public class T252 {
	public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length < 2)
            return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i].end > intervals[i + 1].start)
                return false;
        }
        return true;
    }
	
}

