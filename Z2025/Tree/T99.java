package Z2025.Tree;

import java.util.*;

public class T99 {
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
        public void recoverTree(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inorder(root, list);

            int[] find = find(list);

            traverse(root, find);
        }

        private void inorder(TreeNode root, List<Integer> list){
            if(root == null){
                return;
            }

            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }

        private int[] find(List<Integer> list){
            int[] res = new int[2];
            boolean seen = false;
            for(int i = 0; i < list.size() - 1; i++){
                if(list.get(i) < list.get(i + 1)){
                    continue;
                }
                else{
                    if(!seen){
                        res[0] = list.get(i);
                        seen = true;
                    }
                    res[1] = list.get(i + 1);
                }
            }
            return res;
        }

        private void traverse(TreeNode root, int[] find){
            if(root == null){
                return;
            }

            if(root.val == find[0]){
                root.val = find[1];
            }
            else if(root.val == find[1]){
                root.val = find[0];
            }

            traverse(root.left, find);
            traverse(root.right, find);
        }
    }

}
