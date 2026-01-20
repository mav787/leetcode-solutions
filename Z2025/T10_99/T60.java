package Z2025.T10_99;
import java.util.*;

public class T60 {
    public String getPermutation(int n, int k) {
        // 1. factorials[i] = i!
        int[] factorials = new int[n];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        // 2. 初始化候选数字列表 (1 to n)
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // 3. 将 k 转换为从 0 开始的索引
        k--;

        // 4. 利用阶乘性质计算每一位数字
        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorials[i];
            k %= factorials[i];

            res.append(numbers.get(index));
            numbers.remove(index);
        }

        return res.toString();
    }
}
