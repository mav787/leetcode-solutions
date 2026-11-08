package Z2025.T100_999;

import java.util.*;

public class T346 {
    class MovingAverage {
        int sum;
        int count;
        int size;

        Queue<Integer> queue;

        public MovingAverage(int size) {
            this.size = size;
            queue = new LinkedList<>();
        }

        public double next(int val) {
            queue.offer(val);
            count++;
            sum += val;

            if(count > size){
                count--;
                sum -= queue.poll();
            }

            return (double)sum / count;
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
