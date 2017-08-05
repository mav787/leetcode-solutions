package T300_499;
import java.util.*;
public class T359 {
	private Map<String, Integer> map;
    /** Initialize your data structure here. */
    public T359() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }
        
        int former = map.get(message);
        int gap = timestamp - former;
        if(gap < 10)
            return false;
        map.put(message, timestamp);
        return true;
    }
}
