package A_BinaryTreeTraverseIter;
import java.util.*;

public class C_PostOrder {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode curr = root;
        
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.peek();
            if(curr.right != null && curr.right != pre){		// going down
            	curr = curr.right;
            }
            else{												// going up
                curr = stack.pop();
                res.add(curr.val);
                pre = curr;
                curr = null;
            }
        }
        return res;
    }
}
