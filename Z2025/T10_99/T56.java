package Z2025.T10_99;
import java.util.*;

public class T56 {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return null;
        }

        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0], end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            if(end < intervals[i][0]){
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            else{
                end = Math.max(end, intervals[i][1]);
            }
        }

        list.add(new int[]{start, end});
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
