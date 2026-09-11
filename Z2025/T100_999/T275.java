package Z2025.T100_999;

import java.util.*;

public class T275 {
    public int hIndex(int[] citations) {
        // find smallest i that citations[i] >= n - i

        if(citations == null || citations.length == 0){
            return 0;
        }

        int n = citations.length;
        int left = 0, right = n - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(citations[mid] >= n - mid){
                right = mid;
            }
            else{
                left = mid;
            }
        }

        int i = n;
        if(citations[right] >= n - right){
            i = right;
        }
        if(citations[left] >= n - left){
            i = left;
        }

        return n - i;
    }
}
