package old.C_Meta.T100_999;
import java.util.*;

public class T346 {
    Deque<Integer> deque;
    int size;
    int sum;

    public T346(int size) {
        deque = new LinkedList<Integer>();
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        sum += val;
        if(deque.size() == size){
            sum -= deque.pollFirst();
        }
        deque.offerLast(val);

        return (double)sum / deque.size();
    }
}
