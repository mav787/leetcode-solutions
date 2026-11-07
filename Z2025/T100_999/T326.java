package Z2025.T100_999;

import java.util.*;

public class T326 {
    public boolean isPowerOfThree(int n) {
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        if(n % 3 != 0){
            return false;
        }
        return isPowerOfThree(n / 3);
    }
}
