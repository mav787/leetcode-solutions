package Z2025.Z_Tree;

import java.util.*;

public class T437 {
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

        public int pathSum(TreeNode root, int targetSum) {
            Map<Long, Integer> map = new HashMap<>();
            if(root == null){
                return 0;
            }

            map.put(0L, 1);
            helper(root, targetSum, 0L, map);
            return res;
        }

        private void helper(TreeNode root, int targetSum, long curr, Map<Long, Integer> map){
            if(root == null){
                return;
            }

            long sum = curr + root.val;
            if(map.containsKey(sum - targetSum)){
                res += map.get(sum - targetSum);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

            helper(root.left, targetSum, sum, map);
            helper(root.right, targetSum, sum, map);

            map.put(sum, map.get(sum)  -1);
            // if(map.get(sum) == 0){
            //     map.remove(sum);
            // }
        }
    }
}
