package Z2025.Z_Tree;

public class T114 {
    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root){
        if(root == null){
            return root;
        }

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        root.left = null;
        root.right = left;

        TreeNode curr = root;
        while(curr.right != null){
            curr = curr.right;
        }

        curr.right = right;
        return root;
    }

}
