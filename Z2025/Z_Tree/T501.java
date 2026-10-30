package Z2025.Z_Tree;

import java.util.*;

public class T501 {
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

        public int[] findMode(TreeNode root) {
            Map<Integer, Integer> map = new HashMap<>();
            if(root == null){
                return new int[0];
            }

            helper(root, map);
            List<Integer> res = new ArrayList<>();
            int max = 0;

            for(int key : map.keySet()){
                max = Math.max(max, map.get(key));
            }

            for(int key : map.keySet()){
                if(map.get(key) == max){
                    res.add(key);
                }
            }

            int[] ret = new int[res.size()];
            for(int i = 0; i < ret.length; i++){
                ret[i] = res.get(i);
            }

            return ret;
        }

        private void helper(TreeNode root, Map<Integer, Integer> map){
            if(root == null){
                return;
            }

            int key = root.val;
            map.put(key, map.getOrDefault(key, 0) + 1);

            helper(root.left, map);
            helper(root.right, map);
        }
    }

}
