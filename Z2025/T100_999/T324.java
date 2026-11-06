package Z2025.T100_999;

import java.util.*;

public class T324 {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] dup = nums.clone();
        Arrays.sort(dup);

        int left = (n - 1) / 2;
        int right = n - 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = dup[left];
                left--;
            } else {
                nums[i] = dup[right];
                right--;
            }
        }
    }
}
