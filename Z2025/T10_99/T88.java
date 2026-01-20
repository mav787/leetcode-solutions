package Z2025.T10_99;

public class T88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[curr--] = nums2[j--];
            } else if (j < 0) {
                nums1[curr--] = nums1[i--];
            } else {
                if (nums1[i] > nums2[j]) {
                    nums1[curr--] = nums1[i--];
                } else {
                    nums1[curr--] = nums2[j--];
                }
            }
        }
    }
}
