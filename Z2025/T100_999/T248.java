package Z2025.T100_999;

public class T248 {
    public int strobogrammaticInRange(String low, String high) {
        int[] count = new int[1];

        // 遍历所有可能的长度
        for (int len = low.length(); len <= high.length(); len++) {
            // 使用你的风格：无全局变量，通过数组传递 count
            helper(low, high, new char[len], 0, len - 1, count);
        }

        return count[0];
    }

    private void helper(String low, String high, char[] path, int left, int right, int[] count) {
        // 1. 基准情况：填充完毕
        if (left > right) {
            String s = new String(path);
            // 范围校验 (严格执行大括号)
            if (isWithinRange(s, low, high)) {
                count[0]++;
            }
            return;
        }

        // 2. 成对填充逻辑
        char[][] pairs = {
                {'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}
        };

        for (char[] pair : pairs) {
            // 限制一：不能有前导零（除非长度为 1）
            if (left == 0 && path.length > 1 && pair[0] == '0') {
                continue;
            }

            // 限制二：奇数长度的中点只能放 0, 1, 8
            if (left == right && pair[0] != pair[1]) {
                continue;
            }

            path[left] = pair[0];
            path[right] = pair[1];
            helper(low, high, path, left + 1, right - 1, count);
        }
    }

    private boolean isWithinRange(String s, String low, String high) {
        // 长度相同的情况下比较字典序
        if (s.length() == low.length() && s.compareTo(low) < 0) {
            return false;
        }
        if (s.length() == high.length() && s.compareTo(high) > 0) {
            return false;
        }
        return true;
    }
}
