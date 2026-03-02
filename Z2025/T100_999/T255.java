package Z2025.T100_999;
import java.util.*;

public class T255 {
    public boolean verifyPreorder(int[] preorder) {
        int minLimit = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int num : preorder) {
            while (!stack.isEmpty() && stack.peek() < num) {
                minLimit = stack.pop();
            }

            if (num <= minLimit) {
                return false;
            }

            stack.push(num);
        }

        return true;
    }
}
