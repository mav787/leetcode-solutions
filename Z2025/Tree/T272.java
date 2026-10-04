package Z2025.Tree;

import java.util.*;

public class T272 {
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
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            Deque<Integer> deque = new LinkedList<>();
            inorder(root, deque, target, k);
            return new ArrayList<>(deque);
        }

        private void inorder(TreeNode root, Deque<Integer> deque, double target, int k){
            if(root == null){
                return;
            }

            inorder(root.left, deque, target, k);

            deque.offerLast(root.val);
            if(deque.size() > k){
                double first = Math.abs(deque.peekFirst() - target);
                double last = Math.abs(deque.peekLast() - target);

                if(first < last){
                    deque.pollLast();
                }
                else{
                    deque.pollFirst();
                }
            }


            inorder(root.right, deque, target, k);
        }
    }

}
