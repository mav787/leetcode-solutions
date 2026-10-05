package Z2025.Tree;

import java.util.*;

public class T333 {
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
        public int largestBSTSubtree(TreeNode root) {
            helper(root);
            return res;
        }

        private Helper helper(TreeNode root){
            if(root == null){
                return new Helper(true, Long.MAX_VALUE, Long.MIN_VALUE, 0);
            }

            Helper left = helper(root.left);
            Helper right = helper(root.right);

            // validate BST
            if(!left.isValidBST || !right.isValidBST){
                return new Helper(false, root.val, root.val, 0);
            }

            // validate BST
            if(root.val <= left.max || root.val >= right.min){
                return new Helper(false, root.val, root.val, 0);
            }

            long min = Math.min(root.val, left.min);
            long max = Math.max(root.val, right.max);

            int count = 1 + left.count + right.count;
            res = Math.max(res, count);

            return new Helper(true, min, max, count);
        }
    }

    class Helper{
        boolean isValidBST;
        long min;
        long max;
        int count;

        public Helper(boolean isValidBST, long min, long max, int count){
            this.isValidBST = isValidBST;
            this.min = min;
            this.max = max;
            this.count = count;
        }
    }

}
