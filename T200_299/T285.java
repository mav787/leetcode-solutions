package T200_299;

public class T285 {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while(root != null) {
            if(root.val > p.val) {
                res = root;
                root = root.left;
            }
            else root = root.right;
        }
        return res;
    }
}
