package Z2026.Z0;

public class T1470 {
    class Solution {
        public int[] shuffle(int[] nums, int n) {
            int[] res = new int[2 * n];

            int i = 0, j = n;

            int curr = 0;
            while(curr < res.length){
                res[curr] = nums[i];
                i++;
                curr++;

                res[curr] = nums[j];
                j++;
                curr++;
            }

            return res;
        }
    }

}
