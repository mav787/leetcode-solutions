package T100_199;

public class T114 {
	public void flatten(TreeNode root) {
        if(root == null)
            return;
        helper(root);
    }
    
    private TreeNode helper(TreeNode root){
        if(root == null)
            return null;
        TreeNode flattenleft = helper(root.left), flattenright = helper(root.right);
        if(flattenleft == null){
            root.right = flattenright;
            return root;
        }
        
        TreeNode curr = flattenleft;
        while(curr.right != null){
            curr = curr.right;
        }
        
        root.left = null;
        root.right = flattenleft;
        curr.right = flattenright;
        return root;
        
    }
}
