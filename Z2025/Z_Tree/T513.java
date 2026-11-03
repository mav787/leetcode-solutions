package Z2025.Z_Tree;

import java.util.*;

public class T513 {
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
        public int findBottomLeftValue(TreeNode root) {
            int res = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            if(root == null){
                return res;
            }

            queue.offer(root);

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    TreeNode node = queue.poll();
                    if(i == 0){
                        res = node.val;
                    }

                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                }
            }

            return res;
        }
    }
}
