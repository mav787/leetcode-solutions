package Z2025.T100_999;

public class T152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int prevMax = nums[0];
        int prevMin = nums[0];
        int res = prevMax;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int max = Math.max(
                    curr,
                    Math.max(prevMax * curr, prevMin * curr)
            );
            int min = Math.min(
                    curr,
                    Math.min(prevMax * curr, prevMin * curr)
            );

            prevMax = max;
            prevMin = min;
            res = Math.max(max, res);
        }

        return res;
    }
}
