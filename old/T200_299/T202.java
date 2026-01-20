package old.T200_299;
import java.util.*;
public class T202 {
	public boolean isHappy(int n) {
        if(n <= 0)
            return false;
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            if(!set.add(n))
                return false;
            n = computeNew(n);
        }
        return true;
    }
    
    private int computeNew(int n){
        int res = 0;
        while(n != 0){
            int digit = n % 10;
            res = res + digit * digit;
            n /= 10;
        }
        return res;
    }
}
