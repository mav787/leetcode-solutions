package B_sort;
import java.util.Arrays;
public class QuickSortPractice {
    public static void main(String[] args) {
        int[] x = { 9, 2, 4, 7, 3, 7, 10, 56, 74, 86, 15, 22, 66, 422, 5, 214, 22, 4, 56, 0, 3 , 6, 5, 12, 5, 4234, 258, 4, 4345, -2, 2, 455, 2, 22, 4324, 64, 24, 22, 54};
        System.out.println(Arrays.toString(x));
        quickSort(x);
        System.out.println(Arrays.toString(x));
    }
    
    private static void quickSort(int[] arr){
	    	if(arr == null)
	    		return;
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
    
    private static void swap(int[] nums, int i, int j){
	    	int temp = nums[i];
	    	nums[i] = nums[j];
	    	nums[j] = temp;
    }
}
