package old.T100_199;
import java.util.*;

public class T145Trick {
	
	public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return res;
        stack.push(root);
    	while (!stack.isEmpty()) {
    		TreeNode node = stack.pop();
    		res.addFirst(node.val);
    		if (node.left != null) {
    			stack.push(node.left);
    		}
    		if (node.right != null) {
    			stack.push(node.right);
    		} 
    	}
    	return res;
    }
}
