package Z2025.Z_Tree;

import java.util.*;

public class T508 {
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
        public int[] findFrequentTreeSum(TreeNode root) {
            Map<Integer, Integer> map = new HashMap<>();
            helper(root, map);

            int max = 0;
            for(int key : map.keySet()){
                max = Math.max(max, map.get(key));
            }

            List<Integer> list = new ArrayList<>();
            for(int key : map.keySet()){
                if(map.get(key) == max){
                    list.add(key);
                }
            }

            int[] res = new int[list.size()];
            for(int i = 0; i < res.length; i++){
                res[i] = list.get(i);
            }

            return res;
        }

        private int helper(TreeNode root, Map<Integer, Integer> map){
            if(root == null){
                return 0;
            }

            int left = helper(root.left, map);
            int right = helper(root.right, map);

            int res = left + right + root.val;

            map.put(res, map.getOrDefault(res, 0) + 1);
            return res;
        }
    }
}
