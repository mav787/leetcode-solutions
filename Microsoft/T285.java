package Microsoft;

public class T285 {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)
            return null;        // successor : upper bound
        TreeNode res = null;
        while(root != null){
            if(root.val > p.val) {
                res = root;             // new closest upper bound found
                root = root.left;
            }
            else root = root.right;     // no upper bound
        }
        return res;    
    }
}
