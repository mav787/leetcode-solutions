package Z2025.T100_999;
import java.util.*;

public class T241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);
            // 如果遇到运算符，以此为中心拆分左右两部分
            if (c == '+' || c == '-' || c == '*') {
                // 1. 递归获取左边部分的所有可能结果
                List<Integer> leftList = diffWaysToCompute(expression.substring(0, i));
                // 2. 递归获取右边部分的所有可能结果
                List<Integer> rightList = diffWaysToCompute(expression.substring(i + 1));

                // 3. 笛卡尔积组合左右结果
                for (int leftNum : leftList) {
                    for (int rightNum : rightList) {
                        if (c == '+') {
                            res.add(leftNum + rightNum);
                        } else if (c == '-') {
                            res.add(leftNum - rightNum);
                        } else if (c == '*') {
                            res.add(leftNum * rightNum);
                        }
                    }
                }
            }
        }

        // 4. 边界处理：如果 res 为空，说明 expression 只是一个数字
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }

        return res;
    }
}
