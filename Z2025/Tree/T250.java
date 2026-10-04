package Z2025.Tree;

import java.util.*;

public class T250 {
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return res;
    }

    private boolean helper(TreeNode root){
        if(root == null){
            return true;
        }

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if(!left || !right){
            return false;
        }

        if(root.left != null && root.val != root.left.val){
            return false;
        }

        if(root.right != null && root.val != root.right.val){
            return false;
        }

        res++;
        return true;
    }

}
