package old.T200_299;
import java.util.*;
public class T284 implements Iterator<Integer>{
	private Integer next = null;
    private Iterator<Integer> iter;

    public T284(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext())
            next = iter.next();
    }
    
    // Returns the next element in the iteration without advancing the iterator. 
    public Integer peek() {
        return next; 
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
    	int res = next;
        if(iter.hasNext())
            next = iter.next();
        else
            next = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
