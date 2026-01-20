package old.T100_199;
import java.util.*;

public class T145Set {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if(curr.right != null && !set.contains(curr.right))
                stack.push(curr.right);
            if(curr.left != null && !set.contains(curr.left))
                stack.push(curr.left);
            if(curr == stack.peek()){
                curr = stack.pop();
                set.add(curr);
                res.add(curr.val);
            }
        }
        return res;
    }
}
