package Z2025.Z_Tree;

import java.util.*;

public class T257 {
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            helper(root, res, new StringBuilder());
            return res;
        }

        private void helper(TreeNode root, List<String> res, StringBuilder sb){
            if(root == null){
                return;
            }


            sb.append(root.val).append("->");
            if(root.left == null && root.right == null){
                sb.setLength(sb.length() - 2);
                res.add(sb.toString());
                return;
            }

            int len = sb.length();
            helper(root.left, res, sb);
            sb.setLength(len);

            helper(root.right, res, sb);
        }
    }

}
