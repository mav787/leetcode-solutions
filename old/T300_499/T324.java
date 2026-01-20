package old.T300_499;

public class T324 {
	public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int n = nums.length;
        int l = 0, r = n - 1, rank = n / 2 + 1;
        while(true) {
            // 3-way partition
            int i = l - 1, j = l, k = r;
            int pivot = nums[reindex(r, n)];
            while (j < k) {
                if (nums[reindex(j, n)] > pivot) {
                	i++;
                    swap(nums, reindex(i, n), reindex(j, n));
                    j++;
                } else if (nums[reindex(j, n)] < pivot) {
                	k--;
                    swap(nums, reindex(j, n), reindex(k, n));
                } else j++;
            }
            swap(nums, reindex(j, n), reindex(r, n));
            j++;
            int p = i - l + 2, q = j - l;
            if (p <= rank && rank <= q) return;
            else if (rank > q) {
                rank -= q;
                l = j;
            } else r = i;
        }
    }
    // reindex 
    private int reindex(int i, int n) {
        return (2 * i + 1) % (n | 1);
    }
    // swap
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
