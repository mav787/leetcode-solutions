package old.T200_299;
import java.util.*;

public class T253My {
	public int minMeetingRooms(Interval[] intervals) {
        int res = 0;
        if(intervals == null || intervals.length == 0)
            return res;
        Queue<Integer> starts = new PriorityQueue<>(), ends = new PriorityQueue<>();
        for(Interval i : intervals){
            starts.offer(i.start);
            ends.offer(i.end);
        }
        
        int going = 0;
        while(!starts.isEmpty()){
            int startTime = starts.poll();
            going++;
            res = Math.max(res, going);
            if(starts.isEmpty()){
                return res;
            }
            if(ends.peek() <= starts.peek()){
                ends.poll();
                going--;
            }
            else{
                    // nothing??    
            }
        }
        return res;
    }
}
