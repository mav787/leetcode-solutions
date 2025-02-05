package C_Meta;
import java.util.*;

public class TTT253My {
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) return 0;
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for(int i = 0; i < intervals.length; i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int res = 0;
        int endIndex = 0;			// keep track of (index) the nearest ending
        for(int i = 0; i < len; i++){
            if(starts[i] < ends[endIndex]){
                res++;			// have to create a new room
            }else{
                endIndex++;			// nearest ending ends, reuse that room, update the new nearest ending
            }
        }
        return res;
    }
}
