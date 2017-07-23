package T200_299;

public class T235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null)
            return null;
        if(root.val < Math.min(p.val, q.val))
            return lowestCommonAncestor(root.right, p, q);
        if(root.val > Math.max(p.val, q.val))
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
