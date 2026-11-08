package Z2025.T100_999;

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

        private Result helper(TreeNode root){
            if(root == null){
                return new Result(true, Long.MAX_VALUE, Long.MIN_VALUE, 0);
            }

            Result left = helper(root.left);
            Result right = helper(root.right);

            if(!left.isValid || !right.isValid){
                return new Result(false, 0, 0, 0);
            }

            if(root.val > left.max && root.val < right.min){
                int count = left.count + right.count + 1;
                res = Math.max(res, count);
                return new Result(true, Math.min(root.val, left.min), Math.max(root.val, right.max), count);
            }

            return new Result(false, 0, 0, 0);
        }




        class Result{
            boolean isValid;
            long min;
            long max;
            int count;

            public Result(boolean isValid, long min, long max, int count){
                this.isValid = isValid;
                this.min = min;
                this.max = max;
                this.count = count;
            }
        }
    }
}
