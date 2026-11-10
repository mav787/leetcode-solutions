package Z2025.T100_999;

import java.util.*;

public class T352 {
    class SummaryRanges {
        List<int[]> intervals;

        public SummaryRanges() {
            intervals = new ArrayList<>();
        }

        public void addNum(int value) {
            int index = binarySearch(value);
            // insert
            intervals.add(index, new int[]{value, value});
            merge();
        }

        public int[][] getIntervals() {
            int[][] res = new int[intervals.size()][];
            for(int i = 0; i < res.length; i++){
                res[i] = intervals.get(i);
            }

            return res;
        }

        private void merge(){
            if(intervals.size() <= 1){
                return;
            }

            List<int[]> res = new ArrayList<>();

            // i = start index; j = next index to check
            int i = 0, j = 1;
            while(j < intervals.size()){
                int end = Math.max(intervals.get(i)[1], intervals.get(j - 1)[1]);
                if(end + 1 >= intervals.get(j)[0]){
                    // merge
                    j++;
                }
                else{
                    res.add(new int[]{intervals.get(i)[0], end});
                    i = j;
                    j = i + 1;
                }
            }

            if(i < intervals.size()){
                res.add(new int[]{intervals.get(i)[0], Math.max(intervals.get(i)[1], intervals.get(j - 1)[1])});
            }

            intervals = res;
        }

        private int binarySearch(int value){
            if(intervals.isEmpty()){
                return 0;
            }

            int left = 0, right = intervals.size() - 1;
            // find first i that intervals[i][0] >= value

            while(left + 1 < right){
                int mid = left + (right - left) / 2;
                if(intervals.get(mid)[0] >= value){
                    right = mid;
                }
                else{
                    left = mid;
                }
            }

            if(intervals.get(left)[0] >= value){
                return left;
            }
            else if(intervals.get(right)[0] >= value){
                return right;
            }
            else{
                return intervals.size();
            }
        }

    }

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
}
