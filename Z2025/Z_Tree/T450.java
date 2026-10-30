package Z2025.Z_Tree;

import java.util.*;

public class T450 {
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null){
                return null;
            }

            if(key < root.val){
                root.left = deleteNode(root.left, key);
                return root;
            }
            else if(key > root.val){
                root.right = deleteNode(root.right, key);
                return root;
            }
            else{
                if(root.left == null){
                    return root.right;
                }
                else if(root.right == null){
                    return root.left;
                }
                else{
                    TreeNode left = root.left;
                    TreeNode curr = left;
                    while(curr.right != null){
                        curr = curr.right;
                    }
                    curr.right = root.right;
                    return left;
                }
            }
        }
    }
}
