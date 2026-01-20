package old.T500_699;

public class T538ii {
	public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        traverse(root, 0);
        return root;
    }
    
    private int traverse(TreeNode root, int sum){
        sum = root.right == null ? sum : traverse(root.right, sum);
        root.val += sum;
        return root.left == null ? root.val : traverse(root.left, root.val);
    }
}
