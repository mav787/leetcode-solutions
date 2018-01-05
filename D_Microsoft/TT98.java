package D_Microsoft;

public class TT98 {
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;
        return isValidBST(root.left, min, root.val)
            && isValidBST(root.right, root.val, max)
            && root.val > min
            && root.val < max;
    }
}
