package C_Meta.T10_99;

public class T88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, curr = m + n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] < nums2[j]){
                nums1[curr--] = nums2[j--];
            }
            else{
                nums1[curr--] = nums1[i--];
            }
        }

        while(j >= 0){
            nums1[curr--] = nums2[j--];
        }
    }
}
