package Z2025.T100_999;

import java.util.*;

public class T362 {
    class HitCounter {
        Deque<int[]> queue;
        int count;

        public HitCounter() {
            queue = new ArrayDeque<>();
            count = 0;
        }

        public void hit(int timestamp) {
            if(!queue.isEmpty() && queue.peekLast()[0] == timestamp){
                queue.peekLast()[1]++;
            }
            else{
                queue.offerLast(new int[]{timestamp, 1});
            }

            count++;
        }

        public int getHits(int timestamp) {
            int exp = timestamp - 300;

            while(!queue.isEmpty() && queue.peekFirst()[0] <= exp){
                count -= queue.pollFirst()[1];
            }

            return count;
        }
    }
}
