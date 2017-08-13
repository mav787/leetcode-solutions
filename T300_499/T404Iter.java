package T300_499;
import java.util.*;

public class T404Iter {
	public int sumOfLeftLeaves(TreeNode root) {
	    if(root == null) return 0;
	    int res = 0;
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root);
	    
	    while(!stack.empty()) {
	        TreeNode node = stack.pop();
	        if(node.right != null) {
	            // if (node.right.left != null || node.right.right != null)
	                stack.push(node.right);
	        }
	        if(node.left != null) {
	            if (node.left.left == null && node.left.right == null)
	                res += node.left.val;
	            else
	                stack.push(node.left);
	        }
	    }
	    return res;
	}
}
