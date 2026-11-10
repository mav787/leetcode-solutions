package Z2025.T100_999;

import java.util.*;

public class T357 {
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if(n == 0){
                return 1;
            }
            if(n == 1){
                return 10;
            }


            int[] count = new int[n + 1];
            count[0] = 1;
            count[1] = 10;

            for(int i = 2; i <= n; i++){
                count[i] = 9 * fact9(i - 1);
            }

            int res = 0;
            for(int i = 1; i <= n; i++){
                res += count[i];
            }
            return res;
        }

        private int fact9(int n){
            int res = 1;
            int curr = 9;
            for(int i = 0; i < n; i++){
                res = res * curr;
                curr--;
            }
            return res;
        }
    }

}
