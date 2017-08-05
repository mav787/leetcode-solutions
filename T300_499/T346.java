package T300_499;
import java.util.*;
public class T346 {

    private Queue<Integer> queue;
    private int size;
    private double sum;
    
    /** Initialize your data structure here. */
    public T346(int size) {
        queue = new LinkedList<>();
        this.size = size;
        this.sum = 0;
        
    }
    
    public double next(int val) {
        queue.offer(val);
        sum += val;
        if(queue.size() > size){
            sum -= queue.poll();    
        }
        return sum / queue.size();
    }
}
