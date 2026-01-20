package old.T500_699;
import java.util.*;

public class T683 {
	public int kEmptySlots(int[] flowers, int k) {
        // write your code in Java SE 8
        if(flowers == null) return -1;
        TreeSet<Integer> set = new TreeSet<>();
        
        int days = 1;
        // dummy values
        // set.add(0);
        // set.add(flowers.length + 1);
        
        for(int item : flowers){
            if(set.floor(item) != null && item - set.floor(item) - 1 == k){
                return days;
            }
            if(set.ceiling(item) != null && set.ceiling(item) - item - 1 == k){
                return days;
            }
            set.add(item);
            days++;
        }
        return -1;
    }
}
