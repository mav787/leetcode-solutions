package Z2025.T100_999;
import java.util.*;

public class T239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;

        // 维护一个单调递减的队列
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. 淘汰：如果新元素 nums[i] 大于等于队尾元素，队尾元素永无出头之日，弹出
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // 2. 入队：存储当前元素的索引 i
            deque.offerLast(i);

            // 3. 过期：如果队头的索引已经超出了当前窗口 [i-k+1, i] 的范围，弹出
            while (deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            // 4. 记录：当窗口形成后（i 走到第 k-1 个元素时），队头就是该窗口的最大值
            if (i >= k - 1) {
                res[index++] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}
