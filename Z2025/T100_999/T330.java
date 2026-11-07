package Z2025.T100_999;

import java.util.*;

public class T330 {
    public int minPatches(int[] nums, int n) {
        long covered = 0;  // 当前能连续组成 [0, covered]
        int i = 0;
        int result = 0;

        while (covered < n) {
            if (i < nums.length && nums[i] <= covered + 1) {
                // 情况一：使用已有数字，扩展覆盖范围
                covered += nums[i];
                i++;
            } else {
                // 情况二：补上最小无法组成的数字
                long patch = covered + 1;
                covered += patch;
                result++;
            }
        }

        return result;
    }
}
