package C_FaceBook;
import java.util.*;


public class TTT173 {
	private Stack<TreeNode> stack;

    public TTT173(TreeNode root) {
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
        node = node.right;
        while(node != null){
            stack.push(node);
            node = node.left;
        }
        return res;
    }
}
