package Z2026;

import java.util.*;

public class T852 {
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int left = 0, right = arr.length - 1;
            while(left + 1 < right){
                int mid = left + (right - left) / 2;
                if(arr[mid] > arr[mid - 1]){
                    left = mid;
                }
                else{
                    right = mid;
                }
            }

            if(arr[left] > arr[right]){
                return left;
            }
            return right;
        }
    }

}
