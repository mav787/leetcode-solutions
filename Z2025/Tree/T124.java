package Z2025.Tree;

import java.util.*;

public class T124 {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        helper(root, res);
        return res[0];
    }

    private int helper(TreeNode root, int[] res){
        if(root == null){
            return 0;
        }


        int left = helper(root.left, res);
        int right = helper(root.right, res);

        int sum = root.val + Math.max(0, Math.max(left, right));
        res[0] = Math.max(res[0], sum);
        res[0] = Math.max(res[0], left + root.val + right);

        return sum;
    }

}
