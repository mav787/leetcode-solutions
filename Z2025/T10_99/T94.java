package Z2025.T10_99;
import java.util.*;

public class T94 {
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     if(root == null){
    //         return res;
    //     }
    //     res.addAll(inorderTraversal(root.left));
    //     res.add(root.val);
    //     res.addAll(inorderTraversal(root.right));
    //     return res;
    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            TreeNode curr = node.right;
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
        }
        return res;
    }
}
