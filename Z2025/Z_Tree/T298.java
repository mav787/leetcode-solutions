package Z2025.Z_Tree;

public class T298 {
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
        public int longestConsecutive(TreeNode root) {
            helper(root);
            return res;
        }

        private int helper(TreeNode root){
            if(root == null){
                return 0;
            }

            int left = helper(root.left);
            int right = helper(root.right);

            int curr = 1;
            if(root.left != null && root.val + 1 == root.left.val){
                curr = Math.max(curr, 1 + left);
            }

            if(root.right != null && root.val + 1 == root.right.val){
                curr = Math.max(curr, 1 + right);
            }

            res = Math.max(res, curr);
            return curr;
        }
    }
}
