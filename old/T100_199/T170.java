package old.T100_199;

import java.util.*;

public class T170 {
	Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public T170() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(!map.containsKey(number))
            map.put(number, 1);
        else
            map.put(number, map.get(number) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int i : map.keySet()){
            if(!map.containsKey(value - i))
                continue;
            else{
                if(value - i != i || map.get(value - i) > 1)
                    return true;
            }
        }
        return false;
    }
}
