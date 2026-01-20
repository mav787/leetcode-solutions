package old.G_Salesforce.T1000_9999;
import java.util.*;

public class T2008 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        //Sort based on start time
        Arrays.sort(rides, (a, b) -> a[0] - b[0]);
        long max = 0;

        //Sort based on end time
        // long[] item = {end, rollingSum}
        Queue<long[]> heap = new PriorityQueue<long[]>((a, b) -> Long.compare(a[0], b[0]));

        for (int i = 0; i < rides.length; i++) {
            int start = rides[i][0], end = rides[i][1];
            int tip = rides[i][2];
            long profit = (long)end - start + tip;

            while (!heap.isEmpty() && start >= heap.peek()[0]) {
                long[] trip = heap.poll();
                max = Math.max(max, trip[1]);
            }
            heap.offer(new long[] {end, profit + max});
        }

        while (!heap.isEmpty()) {
            long[] trip = heap.poll();
            max = Math.max(max, trip[1]);
        }

        return max;
    }
}
