package Z2025.T100_999;

public class T223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 1. 计算各自面积
        int s1 = (ax2 - ax1) * (ay2 - ay1);
        int s2 = (bx2 - bx1) * (by2 - by1);

        // 2. 黄金公式：取交集（小的右界 - 大的左界）
        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);

        // 3. 只有宽和高都大于 0 才存在重叠面积
        int intersection = Math.max(0, overlapWidth) * Math.max(0, overlapHeight);

        return s1 + s2 - intersection;
    }
}
