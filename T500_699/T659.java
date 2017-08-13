package T500_699;

public class T659 {
	public boolean isPossible(int[] nums) {
        int n = nums.length;
        int m = nums[n-1] - nums[0] + 1;
        if (m < 3) return false;
        int[] count = new int[m];
        for (int i = 0; i < n; i++) count[nums[i]-nums[0]]++;
        //for (int i = 0; i < m; i++) System.out.print(count[i]);
        int start = 0;
        int p = 0;
        
        while (p < m) {
            while (count[start] == 0) start++;
            p = start + 1;
            while (p < m && count[p] >= count[p-1]) p++;
            if (p-start < 3) return false;
            if (p != m) {
                for (int i = start; i < p; i++) 
                    count[i]--;
                p = 0;
            }
        }
        return count[m-1] == count[m-3];
    }
}
