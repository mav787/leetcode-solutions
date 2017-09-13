package T500_699;

public class T572ii {
	public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null) return false;
        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
