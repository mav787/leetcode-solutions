package Z2025.T100_999;

import java.util.*;

public class T342 {
    public boolean isPowerOfFour(int n) {
        if(n <= 0 || (n & (n - 1)) != 0){
            return false;
        }

        return n % 3 == 1;
    }
}
