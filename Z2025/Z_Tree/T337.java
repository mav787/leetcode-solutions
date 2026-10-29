package Z2025.Z_Tree;

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
            Map<TreeNode, Integer> map = new HashMap<>();
            return helper(root, map);
        }

        private int helper(TreeNode root, Map<TreeNode, Integer> map){
            if(map.containsKey(root)){
                return map.get(root);
            }

            if(root == null){
                return 0;
            }

            // 1. rob this house
            int c1 = root.val;
            if(root.left != null){
                c1 += helper(root.left.left, map);
                c1 += helper(root.left.right, map);
            }

            if(root.right != null){
                c1 += helper(root.right.left, map);
                c1 += helper(root.right.right, map);
            }

            // 2. do not rob this house
            int c2 = 0;
            c2 = helper(root.left, map) + helper(root.right, map);

            int res = Math.max(c1, c2);

            map.put(root, res);
            return res;
        }
    }

}
