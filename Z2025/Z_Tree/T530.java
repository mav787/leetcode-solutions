package Z2025.Z_Tree;

import java.util.*;

public class T530 {
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
        public int getMinimumDifference(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            helper(root, list);
            return getMinimum(list);
        }

        private void helper(TreeNode root, List<Integer> list){
            if(root == null){
                return;
            }

            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }

        private int getMinimum(List<Integer> list){
            int res = Integer.MAX_VALUE;
            for(int i = 1; i < list.size(); i++){
                res = Math.min(res, list.get(i) - list.get(i - 1));
            }

            return res;
        }
    }

}
