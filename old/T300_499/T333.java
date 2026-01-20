package old.T300_499;

public class T333 {
	public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        if(isValidBST(root)){
            return count(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    private boolean isValidBST(TreeNode root){
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;
        return isValidBST(root.left, min, root.val)
            && isValidBST(root.right, root.val, max)
            && root.val > min
            && root.val < max;
    }
    
    private int count(TreeNode root){
        if(root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }
}
