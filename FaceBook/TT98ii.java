package FaceBook;

public class TT98ii {
	public boolean isValidBST(TreeNode root) {
        // if(root == null) return false;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;
        return isValidBST(root.left, min, (long)root.val) && isValidBST(root.right, (long)root.val, max) 
            && root.val > min && root.val < max;
    }
}
