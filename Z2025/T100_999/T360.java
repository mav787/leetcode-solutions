package Z2025.T100_999;

import java.util.*;

public class T360 {
    class Solution {
        int a, b, c;

        public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;


            int n = nums.length;
            int[] res = new int[n];

            if(a == 0){
                for(int i = 0; i < nums.length; i++){
                    res[i] = getVal(nums[i]);
                }

                if(b < 0){
                    reverse(res);
                }

                return res;
            }

            double target = -(double)b / (2 * a);

            int left = 0, right = n - 1;
            while(left + 1 < right){
                int mid = left + (right - left) / 2;
                if(nums[mid] >= target){
                    right = mid;
                }
                else{
                    left = mid;
                }
            }

            int curr = left;
            int currL = curr, currR = curr + 1;
            int i = 0;


            while(currL >= 0 && currR < n){
                double diffL = Math.abs(nums[currL] - target);
                double diffR = Math.abs(nums[currR] - target);

                if(diffL <= diffR){
                    res[i] = getVal(nums[currL]);
                    currL--;
                }
                else{
                    res[i] = getVal(nums[currR]);
                    currR++;
                }
                i++;
            }

            while(currL >= 0){
                res[i] = getVal(nums[currL]);
                currL--;
                i++;
            }

            while(currR < n){
                res[i] = getVal(nums[currR]);
                currR++;
                i++;
            }

            if(a < 0){
                reverse(res);
            }

            return res;
        }

        private void reverse(int[] res){
            int left = 0, right = res.length - 1;
            while(left <= right){
                int temp = res[left];
                res[left] = res[right];
                res[right] = temp;

                left++;
                right--;
            }
        }

        private int getVal(int x){
            return a * x * x + b * x + c;
        }
    }
}
