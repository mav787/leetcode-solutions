package T200_299;

import java.util.*;

public class T295 {
	
	Queue<Integer> min;
    Queue<Integer> max;
    /** initialize your data structure here. */
    public T295() {
        min = new PriorityQueue<Integer>();
        max = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if(min.size() > max.size()){
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size() == min.size()){
            return (max.peek() + min.peek())/2.0;
        }
        else{
            return max.peek();
        }
    }
}
