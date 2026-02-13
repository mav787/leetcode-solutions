package Z2025.T100_999;
import java.util.*;

public class T229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        // 1. 初始化候选人和计数器
        int num1 = 0, num2 = 0;
        int count1 = 0, count2 = 0;

        // 2. 摩尔投票阶段
        for (int num : nums) {
            if (count1 > 0 && num == num1) {
                count1++;
            } else if (count2 > 0 && num == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = num;
                count2 = 1;
            } else {
                // 三方抵消
                count1--;
                count2--;
            }
        }

        // 3. 校验阶段
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            }
        }

        int limit = nums.length / 3;
        if (count1 > limit) {
            res.add(num1);
        }
        if (count2 > limit) {
            res.add(num2);
        }

        return res;
    }
}
