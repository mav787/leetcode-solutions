package Z2025.Z_Tree;

import java.util.*;

public class T563 {
    int res = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        res += Math.abs(left - right);
        return left + right + root.val;
    }
}
