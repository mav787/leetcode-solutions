package B_sort;

import java.util.Arrays;

public class MergeSort {
	//∗∗ Merge-sort contents of array S. ∗/
	public void mergeSort(int[] S) {
		int n = S.length;
		
		// base case
		if (n < 2) return; // array is trivially sorted
		
		// divide
		int mid = n / 2;
		int[] S1 = Arrays.copyOfRange(S, 0, mid); // copy of ﬁrst half
		int[] S2 = Arrays.copyOfRange(S, mid, n); // copy of second half
		// conquer (with recursion)
		mergeSort(S1);
		mergeSort(S2);
		// merge results
		merge(S1, S2, S); // merge sorted halves back into original
	}
	
	
	// Merge contents of arrays S1 and S2 into properly sized array S
	public void merge(int[] S1, int[] S2, int[] S) {
		int i = 0, j = 0;
		while (i + j < S.length){
			if (j == S2.length || (i < S1.length && S1[i] < S2[j])){
				S[i + j] = S1[i++]; // copy ith element of S1 and increment i 
			}
			else{
				S[i + j] = S2[j++]; // copy jth element of S2 and increment j
			}
		}
	}
	
	public static void main(String[] args){
        int[] a = {2, 6, 3, 5, 1, 2, 5, 8, 5, 6};
        System.out.println(Arrays.toString(a));
        MergeSort obj = new MergeSort();
        obj.mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
