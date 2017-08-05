package T300_499;

public class T404DFS {
	public int sumOfLeftLeaves(TreeNode root) {
	    if(root == null) return 0;
	    int res = 0;
	    if(root.left != null) {
	        if(root.left.left == null && root.left.right == null) res += root.left.val;
	        else res += sumOfLeftLeaves(root.left);
	    }
	    res += sumOfLeftLeaves(root.right);
	    
	    return res;
	}
}
