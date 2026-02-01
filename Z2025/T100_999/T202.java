package Z2025.T100_999;
import java.util.*;

public class T202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            if(!set.add(n)){
                return false;
            }
            n = transform(n);
        }
        return true;
    }

    private int transform(int n){
        int res = 0;
        while(n != 0){
            int digit = n % 10;
            n /= 10;
            res += digit * digit;
        }

        return res;
    }
}
