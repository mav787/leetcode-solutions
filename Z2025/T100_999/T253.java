package Z2025.T100_999;
import java.util.*;

public class T253 {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int res = 0;
        int count = 0;

        int i = 0, j = 0;

        while(i < intervals.length){
            if(starts[i] < ends[j]){
                // we have to create a new meeting room
                count++;
                i++;

                res = Math.max(res, count);
            }
            else{
                // we can release an occupied meeting room
                count--;
                j++;
            }
        }

        return res;
    }
}
