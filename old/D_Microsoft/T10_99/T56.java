package old.D_Microsoft.T10_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T56 {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length < 2){
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();

        int start = intervals[0][0], end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            while(i < intervals.length && intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
                i++;
            }
            if(i < intervals.length){
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        res.add(new int[]{start, end});
        int[][] result = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }

        return result;
    }
}
