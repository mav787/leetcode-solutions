package Z2025.T100_999;

import java.util.*;

public class T270 {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }

        // 1. initialize closest value
        int res = root.val;
        TreeNode curr = root;

        // 2. traverse BST iteratively
        while (curr != null) {
            // update closest if closer, or tie-break with smaller value
            double err = Math.abs(curr.val - target);
            double min = Math.abs(res - target);

            if (err < min || (err == min && curr.val < res)) {
                res = curr.val;
            }

            // move pointer
            if (target < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return res;
    }

}
