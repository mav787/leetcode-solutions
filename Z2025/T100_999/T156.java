package Z2025.T100_999;

public class T156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        //  || root.left == null
        if(root == null || root.left == null) {
            return root;
        }

        TreeNode left = root.left, right = root.right;

        root.left = null;
        root.right = null;

        TreeNode newRoot = upsideDownBinaryTree(left);
        left.left = right;
        left.right = root;

        return newRoot;
    }
}
