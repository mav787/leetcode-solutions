package T100_199;

public class T114 {
	public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        if(root.left != null){
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode curr = root;
            while(curr.right != null){
                curr = curr.right;
            }
            curr.right = right;
        }
    }
}
