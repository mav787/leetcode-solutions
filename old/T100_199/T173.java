package old.T100_199;
import java.util.*;


public class T173 {
	Stack<TreeNode> stack;

    public T173(TreeNode root) {
        stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int res = node.val;
        if(node.right != null){
            node = node.right;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
        return res;
    }
}
