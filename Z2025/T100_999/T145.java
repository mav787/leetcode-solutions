package Z2025.T100_999;
import java.util.*;

public class T145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pre = null;

        while(root != null){
            stack.push(root);
            // pre = root;
            root = root.left;
        }

        while(!stack.isEmpty()){
            TreeNode node = stack.peek();

            // going down
            if(node.right != null && node.right != pre){
                node = node.right;
                while(node != null){
                    stack.push(node);
                    node = node.left;
                }
            }

            // going up
            // node.right == null || node.right == pre
            else{
                node = stack.pop();
                res.add(node.val);
                pre = node;
            }
        }

        return res;
    }
}
