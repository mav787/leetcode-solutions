package FaceBook;

public class TT98 {
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max){
        if(root == null)
            return true;
        long rootvalue = (long)root.val;
        if(rootvalue <= min || rootvalue >= max)
            return false;
        return isValidBST(root.left, min, rootvalue) && isValidBST(root.right, rootvalue, max);
    }
}
