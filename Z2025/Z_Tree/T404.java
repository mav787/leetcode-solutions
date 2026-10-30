package Z2025.Z_Tree;

import java.util.*;

public class T404 {
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
        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null){
                return 0;
            }

            helper(root.left, true);
            helper(root.right, false);
            return res;
        }

        private void helper(TreeNode root, boolean isLeft){
            if(root == null){
                return;
            }

            if(isLeft){
                if(root.left == null && root.right == null){
                    res += root.val;
                    return;
                }
            }

            helper(root.left, true);
            helper(root.right, false);
        }
    }
}
