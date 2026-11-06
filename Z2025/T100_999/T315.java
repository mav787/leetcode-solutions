package Z2025.T100_999;

import java.util.*;

public class T315 {

    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            int[] indexes = new int[n];
            int[] temp = new int[n];
            int[] count = new int[n];

            for(int i = 0; i < n; i++){
                indexes[i] = i;
            }

            mergeSort(nums, indexes, temp, count, 0, n - 1);

            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < n; i++){
                res.add(count[i]);
            }

            return res;
        }

        private void mergeSort(int[] nums, int[] indexes, int[] temp,
                               int[] count, int left, int right) {
            if(left >= right){
                return;
            }

            int mid = left + (right - left) / 2;

            mergeSort(nums, indexes, temp, count, left, mid);
            mergeSort(nums, indexes, temp, count, mid + 1, right);

            int i = left;
            int j = mid + 1;
            int k = left;

            while(i <= mid && j <= right){
                if(nums[indexes[i]] <= nums[indexes[j]]){
                    count[indexes[i]] += j - (mid + 1);
                    temp[k++] = indexes[i++];
                }
                else{
                    temp[k++] = indexes[j++];
                }
            }

            while(i <= mid){
                count[indexes[i]] += j - (mid + 1);
                temp[k++] = indexes[i++];
            }

            while(j <= right){
                temp[k++] = indexes[j++];
            }

            for(int p = left; p <= right; p++){
                indexes[p] = temp[p];
            }
        }
    }


}
