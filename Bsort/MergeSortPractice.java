package Bsort;

import java.util.*;

public class MergeSortPractice{
	public static void main(String[] args){
        int[] a = {2, 6, 3, 5, 1};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] a){
    		int[] tmp = new int[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }
    
    private static void mergeSort(int[] a, int[] tmp, int left, int right){
        if( left < right ){
            int center = left + (right - left) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }
    
    private static void merge(int[] a, int[] tmp, int left, int right, int rightEnd){
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd){
            if(a[left] < a[right])
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];
        }

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
        
    }
}