package Z2025.T100_999;
import java.util.*;

public class T225 {
    Queue<Integer> queue;

    public T225() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        for(int i = 0; i < queue.size() - 1; i++){
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
