package Z2025.T100_999;

public class T114 {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left == null){
            return;
        }

        root.left = null;
        root.right = left;

        while(left.right != null){
            left = left.right;
        }
        left.right = right;
    }
}
