package Z2025.T100_999;
import java.util.*;

public class T247 {
    public List<String> findStrobogrammatic(int n) {
        // 直接调用递归辅助函数，不使用成员变量
        return helper(n, n);
    }

    private List<String> helper(int n, int max) {
        // 1. 基准情况
        if (n <= 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }

        // 2. 递归获取 n-2 的所有组合
        List<String> list = helper(n - 2, max);
        List<String> res = new ArrayList<>();

        // 3. 遍历并向两端添加对称对 (严格执行大括号)
        for (String s : list) {
            // 只有当前长度不等于最大长度时，才允许在两端加 '0'
            if (n != max) {
                res.add("0" + s + "0");
            }

            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }

        return res;
    }
}
