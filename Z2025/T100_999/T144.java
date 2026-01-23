package Z2025.T100_999;
import java.util.*;

public class T144 {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if(root == null){
//            return res;
//        }
//
//        res.add(root.val);
//        res.addAll(preorderTraversal(root.left));
//        res.addAll(preorderTraversal(root.right));
//        return res;
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        while(root != null){
            res.add(root.val);

            stack.push(root);
            root = root.left;
        }

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            node = node.right;

            while(node != null){
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
        }

        return res;
    }
}
