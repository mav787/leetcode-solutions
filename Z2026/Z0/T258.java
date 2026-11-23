package Z2026;

import java.util.*;

public class T258 {
    class Solution {
        public int addDigits(int num) {
            while(num > 9){
                num = helper(num);
            }

            return num;
        }

        private int helper(int num){
            int sum = 0;
            while(num != 0){
                sum += num % 10;
                num /= 10;
            }

            return sum;
        }
    }

}
