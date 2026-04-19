package Z2025.T100_999;

public class T261 {
    public boolean validTree(int n, int[][] edges) {
        // 核心底线：n 个节点的有效树，必须恰好有 n - 1 条边
        // 这一步直接排除了多余的边（必然有环）和过少的边（必然不连通）
        if (edges.length != n - 1) {
            return false;
        }

        // 初始化并查集：一开始，每个节点的父节点都是它自己（自己是自己的老大）
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 遍历所有边，开始“认大哥”并合并集合
        for (int[] edge : edges) {
            int rootU = find(parent, edge[0]);
            int rootV = find(parent, edge[1]);

            // 💥 发现成环：如果这两个节点的“最终老大”是同一个人
            // 说明它们之前早就通过其他节点连通了，现在又加了一条边，绝对成环了！
            if (rootU == rootV) {
                return false;
            }

            // 没成环，那就把这两个连通分量合并（让 u 的老大认 v 的老大做大哥）
            parent[rootU] = rootV;
        }

        // 只要挺过了边数校验，且中间没发现环，它就毫无悬念是一棵树
        return true;
    }

    // 递归查找“最终老大”的函数（附带路径压缩优化，效率拉满）
    private int find(int[] parent, int i) {
        // 如果我的老大哥是我自己，那我就是这个集合的最终根节点
        if (parent[i] == i) {
            return i;
        }
        // 路径压缩：顺藤摸瓜找到真正老大的同时，把沿途的所有小弟直接挂在真正老大的名下
        // 下次再找就一步到位了，时间复杂度直接降到 O(1) 级别
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}
