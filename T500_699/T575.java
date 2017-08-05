package T500_699;
import java.util.*;

public class T575 {
	public int distributeCandies(int[] candies) {
        if(candies == null || candies.length % 2 != 0)
            return -1;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < candies.length; i++){
            set.add(candies[i]);
            if(set.size() >= candies.length / 2)
                return candies.length / 2;
        }
        return set.size();
    }
}
