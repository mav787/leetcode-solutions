package Z2025.Z_Tree;

public class T285 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if(root == null){
                return null;
            }

            if(root.val <= p.val){
                return inorderSuccessor(root.right, p);
            }
            else{
                TreeNode left = inorderSuccessor(root.left, p);
                if(left != null){
                    return left;
                }
                else{
                    return root;
                }
            }
        }
    }

}
