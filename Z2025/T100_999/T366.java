package Z2025.T100_999;

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
            helper(root, res);
            return res;
        }

        private int helper(TreeNode root, List<List<Integer>> res){
            if(root == null){
                return -1;
            }

            int left = helper(root.left, res);
            int right = helper(root.right, res);

            int index = Math.max(left, right) + 1;

            while(res.size() <= index){
                res.add(new ArrayList<>());
            }

            List<Integer> list = res.get(index);
            list.add(root.val);

            return index;
        }
    }

}
