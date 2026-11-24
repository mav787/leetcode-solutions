package Z2026.Z0;

public class T1486 {
    class Solution {
        public int xorOperation(int n, int start) {
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = start + 2 * i;
            }

            int res = 0;
            for(int num : nums){
                res ^= num;
            }

            return res;
        }
    }
}
