package old.T500_699;

public class T543My {
	public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        
        int leftWithRoot = longestPath(root.left);
        int rightWithRoot = longestPath(root.right);
        
        return Math.max(left, Math.max(right, leftWithRoot + rightWithRoot));
    }
    
    private int longestPath(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(longestPath(root.left), longestPath(root.right)) + 1;
    }
}
