package old.T300_499;

public class T337My {
	public int rob(TreeNode root) {
        if(root == null) return 0;
        
        int robCurr = root.val;
        if(root.left != null){
            robCurr += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            robCurr += rob(root.right.left) + rob(root.right.right);
        }    
        
        int robChildren = rob(root.left) + rob(root.right);
        
        return Math.max(robCurr, robChildren);
    }
}
