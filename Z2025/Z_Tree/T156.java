package Z2025.Z_Tree;

public class T156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null){
            return root;
        }

        TreeNode left = upsideDownBinaryTree(root.left);

        root.left.right = root;
        root.left.left = root.right;

        root.left = null;
        root.right = null;

        return left;
    }
}
