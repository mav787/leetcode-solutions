package Z2025.Z_Tree;

import java.util.*;

public class T145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        // left, right, root
        // root, right, left

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            res.add(0, curr.val);

            if(curr.left != null){
                stack.push(curr.left);
            }

            if(curr.right != null){
                stack.push(curr.right);
            }
        }

        return res;
    }
}
