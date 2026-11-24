package Z2025.T100_999;

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
        public int sumOfLeftLeaves(TreeNode root) {
            int[] res = new int[1];
            if(root == null){
                return 0;
            }

            helper(root.left, true, res);
            helper(root.right, false, res);
            return res[0];
        }

        private void helper(TreeNode root, boolean isLeft, int[] res){
            if(root == null){
                return;
            }

            if(isLeft){
                if(root.left == null && root.right == null){
                    res[0] += root.val;
                }
            }

            helper(root.left, true, res);
            helper(root.right, false, res);
        }
    }
}
