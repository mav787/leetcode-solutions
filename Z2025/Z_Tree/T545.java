package Z2025.Z_Tree;

import java.util.*;

public class T545 {

    class Solution {
        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            res.add(root.val);

            addLeft(root.left, res);
            addLeaves(root.left, res);
            addLeaves(root.right, res);
            addRight(root.right, res);

            return res;
        }

        private void addLeft(TreeNode root, List<Integer> res) {
            while (root != null) {
                if (root.left == null && root.right == null) {
                    break;
                }

                res.add(root.val);

                if (root.left != null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }

        private void addLeaves(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                res.add(root.val);
                return;
            }

            addLeaves(root.left, res);
            addLeaves(root.right, res);
        }

        private void addRight(TreeNode root, List<Integer> res) {
            Stack<Integer> stack = new Stack<>();

            while (root != null) {
                if (root.left == null && root.right == null) {
                    break;
                }

                stack.push(root.val);

                if (root.right != null) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }

            while (!stack.isEmpty()) {
                res.add(stack.pop());
            }
        }
    }

}
