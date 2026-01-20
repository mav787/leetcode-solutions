package old.T300_499;
import java.util.*;

// This is a Randomized Set
public class T380 {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random rand;
    /** Initialize your data structure here. */
    public T380() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) 
        	return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) 
        	return false;
        int loc = map.get(val);
        if (loc < list.size() - 1 ) {                   // not the last one
            int lastone = list.get(list.size() - 1 );   // get the REAL last one
            list.set(loc , lastone);                    // put the REAL last one to this position..
            map.put(lastone, loc);                     // and updates its position
        }
        map.remove(val);                               // remove this item
        list.remove(list.size() - 1);                   // and remove it in the arraylist
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
