package B_sort;
import java.util.Arrays;
public class QuickSort {
    public static void main(String[] args) {
        int[] x = { 9, 2, 4, 7, 3, 7, 10 };
        System.out.println(Arrays.toString(x));
 
        quickSort(x);
        System.out.println(Arrays.toString(x));
    }
    
    public static void quickSort(int[] arr){
	    	if(arr == null || arr.length < 2) return;
	    	quickSort(arr, 0, arr.length - 1);
    }
 
    private static void quickSort(int[] arr, int left, int right){
	    	if(left >= right)
	    		return;
	    	int pivot = arr[right];
	    	int curr = left;
	    	for(int i = left; i < right; i++){
	    		if(arr[i] < pivot){
	    			swap(arr, i, curr);
	    			curr++;
	    		}
	    	}
	    	
	    	swap(arr, curr, right);
	    	quickSort(arr, left, curr - 1);
	    	quickSort(arr, curr + 1, right);
    }

    private static void swap(int[] arr, int i, int j){
	    	int temp = arr[i];
	    	arr[i] = arr[j];
	    	arr[j] = temp;
    }
}
