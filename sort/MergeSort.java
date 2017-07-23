package sort;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args){
        int[] a = {2, 6, 3, 5, 1, 2464, 5646462, -546, 248, 7 , 8, 9877654, 23434, 445, 2, 45 ,54, 577};
        System.out.println(Arrays.toString(a));
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
    
    private static void mergeSort(int[] arr){
    	if(arr == null || arr.length < 2)
    		return;
    	int len = arr.length;
    	int[] first = new int[len / 2];
    	int[] second = new int[len - len / 2];
    	System.arraycopy(arr, 0, first, 0, len / 2);
    	System.arraycopy(arr, len / 2, second, 0, len - len / 2);
    	mergeSort(first);
    	mergeSort(second);
    	merge(first, second, arr);
    }
    
    private static void merge(int[] first, int[] second, int[] arr){
    	int curr1 = 0, curr2 = 0, curr = 0;
    	while(curr1 < first.length || curr2 < second.length){
    		if(curr1 >= first.length)
    			arr[curr++] = second[curr2++];
    		else if(curr2 >= second.length)
    			arr[curr++] = first[curr1++];
    		else{
    			if(first[curr1] < second[curr2])
    				arr[curr++] = first[curr1++];
    			else
    				arr[curr++] = second[curr2++];
    		}
    	}
    }
}
