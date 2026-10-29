package Z2025.Z_Tree;

import java.util.*;

public class T366 {
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
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, root);
            return res;
        }

        // returns HEIGHT of root
        // height: bottom up
        // depth: top down
        // 我好像开窍了 这里
        private int helper(List<List<Integer>> res, TreeNode root){
            if(root == null){
                return -1;
            }

            int left = helper(res, root.left);
            int right = helper(res, root.right);


            int depth = Math.max(left, right) + 1;

            if(depth >= res.size()){
                res.add(new ArrayList<>());
            }

            List<Integer> list = res.get(depth);
            list.add(root.val);
            return depth;
        }
    }
}
