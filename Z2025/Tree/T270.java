package Z2025.Tree;

import java.util.*;

public class T270 {
    public int closestValue(TreeNode root, double target) {
        if(root.left == null && root.right == null){
            return root.val;
        }

        int res = root.val;

        if(root.val > target && root.left != null){
            int left = closestValue(root.left, target);
            if(Math.abs(left - target) <= Math.abs(res - target)){
                res = left;
            }
        }
        if(root.val < target && root.right != null){
            int right = closestValue(root.right, target);
            if(Math.abs(right - target) < Math.abs(res - target)){
                res = right;
            }
        }

        return res;
    }
}
