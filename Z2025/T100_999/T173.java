package Z2025.T100_999;
import java.util.*;

public class T173 {
    Stack<TreeNode> stack;
    TreeNode curr;

    public T173(TreeNode root) {
        stack = new Stack<>();
        curr = root;
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }

        if(!stack.isEmpty()){
            curr = stack.peek();
        }
    }

    public int next() {
        if(!stack.isEmpty()){
            curr = stack.pop();
            int res = curr.val;

            curr = curr.right;
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            if(!stack.isEmpty()){
                curr = stack.peek();
            }

            return res;
        }

        return -1;
    }

    public boolean hasNext() {
        return curr != null;
    }
}
