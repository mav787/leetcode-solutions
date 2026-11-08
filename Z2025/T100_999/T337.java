package Z2025.T100_999;

import java.util.*;

public class T337 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public int rob(TreeNode root) {
            int[] res = helper(root);
            return Math.max(res[0], res[1]);
        }

        private int[] helper(TreeNode root){
            // res[0]: rob this house; res[1]: DO NOT rob this house
            int[] res = new int[2];

            if(root == null){
                return res;
            }

            int[] left = helper(root.left);
            int[] right = helper(root.right);

            res[0] = root.val + left[1] + right[1];

            res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            return res;
        }
    }

}
