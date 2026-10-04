package Z2025.Tree;

import java.util.*;

public class T144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null){
            res.add(curr.val);
            stack.push(curr);
            curr = curr.left;
        }

        while(!stack.isEmpty()){
            curr = stack.pop();
            curr = curr.right;
            while(curr != null){
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
        }

        return res;
    }

}
