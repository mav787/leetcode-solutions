package T1_99;

public class TT88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null)
            return;
        int curr1 = m - 1, curr2 = n - 1, curr = m + n - 1;
        while(curr1 >= 0 && curr2 >= 0){
            nums1[curr--] = nums1[curr1] > nums2[curr2] ? nums1[curr1--] : nums2[curr2--];    
        }
        
        while(curr2 >= 0){
            nums1[curr--] = nums2[curr2--];
        }
    }
}
