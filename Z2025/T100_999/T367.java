package Z2025.T100_999;

import java.util.*;

public class T367 {
    class Solution {
        public boolean isPerfectSquare(int num) {
            if(num < 1){
                return false;
            }

            int left = 1, right = num;
            while(left + 1 < right){
                int mid = left + (right - left) / 2;
                if(num / mid > mid){
                    left = mid;
                }
                else{
                    right = mid;
                }
            }

            if(left * left == num || right * right == num){
                return true;
            }
            else{
                return false;
            }
        }
    }

}
