package Z2025.T100_999;
import java.util.*;

public class T218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();

        // 1. 将所有建筑拆分为：左边界进入 和 右边界离开
        // 为了区分，我们将左边界高度设为负数，右边界高度设为正数（这是一个排序小技巧）
        List<int[]> points = new ArrayList<>();
        for (int[] b : buildings) {
            points.add(new int[]{b[0], -b[2]}); // 左边界
            points.add(new int[]{b[1], b[2]});  // 右边界
        }

        // 2. 排序：按坐标 x 升序；x 相同则按高度 h 升序
        // 注意：因为左边界高度是负的，这保证了 x 相同时，高的建筑先进入
        Collections.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // 3. 惰性删除堆：存的是高度及其出现的次数（这里用 TreeMap 模拟惰性堆更方便）
        // key -> value = height -> count
        // 或者直接用 PriorityQueue + 一个记录“已过期建筑”的 Map
        TreeMap<Integer, Integer> heights = new TreeMap<>(Collections.reverseOrder());
        heights.put(0, 1); // 基础地平线，保证堆永远不为空

        int prevMaxHeight = 0;

        for (int[] p : points) {
            int x = p[0];
            int h = Math.abs(p[1]);

            if (p[1] < 0) {
                // left of building：高度入堆
                heights.put(h, heights.getOrDefault(h, 0) + 1);
            } else {
                // right of building：高度出堆（这就是我们要的删除操作）
                int count = heights.get(h);
                if (count == 1) heights.remove(h);
                else heights.put(h, count - 1);
            }

            // 4. 检查当前最高高度是否发生了变化
            int currMaxHeight = heights.firstKey();
            if (currMaxHeight != prevMaxHeight) {
                res.add(Arrays.asList(x, currMaxHeight));
                prevMaxHeight = currMaxHeight;
            }
        }

        return res;
    }
}
