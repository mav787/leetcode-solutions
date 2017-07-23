package T200_299;
import java.util.*;

public class T253Ans {
	public int minMeetingRooms(Interval[] intervals) {
        int roomNum = 0;
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for(int i = 0; i < intervals.length; i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int endIndex = 0;			// keep track of (index) the nearest ending
        for(int i = 0; i < len; i++){
            if(starts[i] < ends[endIndex]){
                roomNum++;			// have to create a new room
            }else{
                endIndex++;			// nearest ending ends, reuse that room, update the new nearest ending
            }
        }
        return roomNum;
    }
}
