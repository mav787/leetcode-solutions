package Z2025.T100_999;
import java.util.*;

public class T220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // 使用 TreeSet 维护大小为 indexDiff 的滑动窗口
        // 使用 Long 防止减法溢出
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long x = (long) nums[i];

            // 找窗口中大于等于 x - valueDiff 的最小值
            Long ceiling = set.ceiling(x - valueDiff);
            if (ceiling != null && ceiling <= x + valueDiff) {
                return true;
            }

            set.add(x);
            // 保持窗口大小
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}
