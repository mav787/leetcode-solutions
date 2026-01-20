package old.T1_99;

public class T4ii {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = m + n;
        
        if((k & 1) == 1){
            return find(nums1, 0, m, nums2, 0, n, k / 2 + 1);
        }
        else{
            return (find(nums1, 0, m, nums2, 0, n, k / 2) + find(nums1, 0, m, nums2, 0, n, k / 2 + 1)) / 2;
        }
    }
    public double find(int[] A, int aStart, int alength, int[] B, int bStart, int blength,int kth){
        if(alength > blength)
        	return find(B, bStart, blength, A, aStart, alength, kth);
        if(alength == 0)
        	return B[bStart + kth - 1];
        if (kth == 1)
        	return Math.min(B[bStart], A[aStart]);
        int p = kth / 2;
        int q = kth - p;
        if(alength < p){
            p = alength;
            q = kth - p;
        }
        if(A[aStart + p - 1] > B[bStart + q - 1])
        	return find(A, aStart, alength, B, bStart + q, blength - q, kth - q);
        else
        	return find(A, aStart + p, alength - p, B, bStart, blength, kth - p);
        
    }
    
}
