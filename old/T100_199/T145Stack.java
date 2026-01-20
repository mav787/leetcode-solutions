package old.T100_199;
import java.util.*;

//import BinaryTreeTraverseIter.TreeNode;

public class T145Stack {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            if(curr.right != null && curr.right != pre){
            	curr = curr.right;
            }
            else{
                curr = stack.pop();
                res.add(curr.val);
                pre = curr;
                curr = null;
            }
        }
        return res;
    }
}
