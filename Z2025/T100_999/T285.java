package Z2025.T100_999;

import java.util.*;

public class T285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) {
            return null;
        }

        if(p.val >= root.val){
            return inorderSuccessor(root.right, p);
        }

        TreeNode left = inorderSuccessor(root.left, p);

        if(left != null){
            return left;
        }

        return root;
    }
}
