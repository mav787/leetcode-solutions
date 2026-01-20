package old.C_Meta;
import java.util.*;

public class TTT253Heap {
	public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
            
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        Queue<Interval> heap = new PriorityQueue<Interval>(intervals.length, (a, b) -> a.end - b.end);
        
        heap.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = heap.poll();
            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);
        }
        return heap.size();
    }
}


















class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }
