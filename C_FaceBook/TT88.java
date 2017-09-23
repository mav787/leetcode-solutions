package C_FaceBook;

public class TT88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null) return;
        int curr = m + n - 1;
        int curr1 = m - 1, curr2 = n - 1;
        while(curr >= 0){
            int val1 = curr1 >= 0 ? nums1[curr1] : Integer.MIN_VALUE;
            int val2 = curr2 >= 0 ? nums2[curr2] : Integer.MIN_VALUE;
            
            if(val1 >= val2){
                nums1[curr] = nums1[curr1];
                curr1--;
            }
            else{
                nums1[curr] = nums2[curr2];
                curr2--;
            }
            curr--;
        }
    }
}
