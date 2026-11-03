package Z2025.Z_Tree;

import java.util.*;

public class T572 {
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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if(root == null && subRoot == null){
                return true;
            }

            if(root == null || subRoot == null){
                return false;
            }

            if(isSameTree(root, subRoot)){
                return true;
            }

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean isSameTree(TreeNode root, TreeNode subRoot){
            if(root == null && subRoot == null){
                return true;
            }

            if(root == null || subRoot == null){
                return false;
            }

            return root.val == subRoot.val && isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
        }
    }

}
