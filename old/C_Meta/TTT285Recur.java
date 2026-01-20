package old.C_Meta;

public class TTT285Recur {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }

        TreeNode left = inorderSuccessor(root.left, p);
        return (left == null) ? root : left;
    }
}
