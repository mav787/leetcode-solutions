package Z2025.T100_999;

import java.util.*;

public class T414 {
    class Solution {
        public int thirdMax(int[] nums) {
            long max1 = Long.MIN_VALUE;
            long max2 = max1, max3 = max1;

            for(int num : nums){
                if(num == max1 || num == max2 || num == max3){
                    continue;
                }
                if(num > max1){
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                }
                else if(num > max2){
                    max3 = max2;
                    max2 = num;
                }
                else if(num > max3){
                    max3 = num;
                }
            }

            return max3 == Long.MIN_VALUE ? (int)max1 : (int)max3;
        }
    }
}
