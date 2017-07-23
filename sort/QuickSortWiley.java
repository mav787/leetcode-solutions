package sort;

import java.util.Arrays;

public class QuickSortWiley {
	// Sort the subarray S[a..b] inclusive. 
	
	public static void main(String[] args) {
        int[] x = { 9, 2, 4, 7, 3, 7, 10 };
        System.out.println(Arrays.toString(x));
 
        int low = 0;
        int high = x.length - 1;
 
        quickSortInPlace(x, low, high);
        System.out.println(Arrays.toString(x));
    }
	
	private static void quickSortInPlace(int[] S,  int a, int b) {
		if (a >= b) {
			return; // subarray is trivially sorted
		}
		int left = a;
		int right = b - 1;
		int pivot = S[b];
		//int temp;
		
		while (left <= right) {
			 // scan until reaching value equal or larger than pivot (or right marker)
			while (left <= right && S[left] < pivot) {
				left++;
			}
			
			while (left <= right && S[right] > pivot) {
				right--;
			}
			if (left <= right) { // indices did not strictly cross
				// so swap values and shrink range
				int temp = S[left]; 
				S[left] = S[right]; 
				S[right] = temp;
				left++; 
				right--;
			}
		}
		// put pivot into its ﬁnal place (currently marked by left index)
		int tmp = S[left]; 
		S[left] = S[b]; 
		S[b] = tmp;
		
		// make recursive calls
		quickSortInPlace(S, a, left - 1);
		quickSortInPlace(S, left + 1, b);
	}
}
