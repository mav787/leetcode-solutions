package Z2025.Z_Tree;

import java.util.*;

public class T543 {
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
        int res = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            helper(root);
            return res;
        }

        private int helper(TreeNode root){
            if(root == null){
                return 0;
            }

            int left = helper(root.left);
            int right = helper(root.right);

            int ret = Math.max(left, right) + 1;
            res = Math.max(res, left + right);

            return ret;
        }
    }
}
