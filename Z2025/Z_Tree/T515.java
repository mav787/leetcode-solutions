package Z2025.Z_Tree;

import java.util.*;

public class T515 {
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
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null){
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                int size = queue.size();
                int curr = Integer.MIN_VALUE;

                for(int i = 0; i < size; i++){
                    TreeNode node = queue.poll();
                    curr = Math.max(curr, node.val);

                    if(node.left != null){
                        queue.offer(node.left);
                    }

                    if(node.right != null){
                        queue.offer(node.right);
                    }
                }
                res.add(curr);
            }
            return res;
        }
    }

}
