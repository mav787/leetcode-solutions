package old.C_Meta.T100_999;
import java.util.*;

public class T986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            // Let's check if A[i] intersects B[j].
            // start - the startpoint of the intersection
            // end - the endpoint of the intersection
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if (start <= end) {
                res.add(new int[]{start, end});
            }

            // Remove the interval with the smallest endpoint
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            }
            else {
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
