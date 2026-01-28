package Z2025.T100_999;
import java.util.*;

public class T149 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int res = 0;

        // 核心改动：我们不再全局统计 Line，而是固定一个点 i，统计其他点与 i 的斜率
        // 这样可以避免计算截距 b，因为所有过点 i 且斜率相同的点必然在同一条线上
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int maxForThisPoint = 0;
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // 使用 GCD 简化分数，代替 double 斜率
                int common = gcd(dx, dy);
                String k = (dy / common) + "/" + (dx / common);

                map.put(k, map.getOrDefault(k, 0) + 1);
                maxForThisPoint = Math.max(maxForThisPoint, map.get(k));
            }
            res = Math.max(res, maxForThisPoint + 1);
        }
        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
