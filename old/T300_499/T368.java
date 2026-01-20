package old.T300_499;
import java.util.*;
public class T368 {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if(nums == null || nums.length == 0) return res;
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        Arrays.sort(nums);
        int max = 0, index = -1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 ) {
                    if(count[i] < count[j] + 1){
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
