package Z2025.T100_999;

import java.util.*;

public class T281 {
    public static class ZigzagIterator {

        Queue<Iterator<Integer>> queue;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            queue = new LinkedList<>();
            if(!v1.isEmpty()){
                queue.offer(v1.iterator());
            }
            if(!v2.isEmpty()){
                queue.offer(v2.iterator());
            }
        }

        public int next() {
            Iterator<Integer> i = queue.poll();
            int res = i.next();
            if(i.hasNext()){
                queue.offer(i);
            }

            return res;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
