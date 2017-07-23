package T100_199;

public class T110 {
	public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return maxDepth(root) != -1;
    }
    
    private int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        if(maxDepth(root.left) == -1)
            return -1;
        if(maxDepth(root.right) == -1)
            return -1;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
