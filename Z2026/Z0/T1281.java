package Z2026;

import java.util.*;

public class T1281 {
    class Solution {
        public int subtractProductAndSum(int n) {

            int product = 1;
            int sum = 0;

            while(n != 0){
                int digit = n % 10;
                product *= digit;
                sum += digit;

                n /= 10;
            }

            return product - sum;
        }
    }
}
