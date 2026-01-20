package old.T500_699;

public class T669 {
	public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null || L > R) return null;
        if(root.val < L) return trimBST(root.right, L, R);
        if(root.val > R) return trimBST(root.left, L, R);
        
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
