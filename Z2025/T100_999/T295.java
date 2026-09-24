package Z2025.T100_999;

import java.util.*;

public class T295 {
    static class MedianFinder {

        Queue<Integer> q1, q2;

        public MedianFinder() {
            // q1: smallest on top
            q1 = new PriorityQueue<>();

            // q2: largest on top
            q2 = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            // goal: q1 stores the larger half
            // q2 stores the smaller half
            // invariant #1: q1.size() >= q2.size
            // invariant #2: max(q2) < min(q1)

            q1.offer(num);
            q2.offer(q1.poll());

            if(q2.size() > q1.size()){
                q1.offer(q2.poll());
            }
        }

        public double findMedian() {
            if(q1.size() > q2.size()){
                return q1.peek();
            }
            else{
                return (q1.peek() + q2.peek()) / 2.0;
            }
        }
    }
}
