package FaceBook;

public class T572 {
	public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null)
            return false;
        if(isIdentical(s, t))
            return true;
        if(isSubtree(s.left, t))
            return true;
        if(isSubtree(s.right, t))
            return true;
        return false;
    }
    
    private boolean isIdentical(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        return s.val == t.val && isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
    }
}
