package old.T1_99;
import java.util.*;

public class TT94My {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(curr);
        boolean flag = true;
        while(!stack.isEmpty()){
            while(curr.left != null && flag){
                curr = curr.left;
                stack.push(curr);
            }
            curr = stack.pop();
            res.add(curr.val);
            flag = false;
            if(curr.right != null){
                curr = curr.right;
                stack.push(curr);
                flag = true;
            }
        }
        return res;
    }
}
