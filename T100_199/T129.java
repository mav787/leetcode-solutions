package T100_199;

public class T129 {
	int res = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return res;
        traverse(root, 0);
        return res;
    }
    
    private void traverse(TreeNode root, int parentval){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            res += parentval * 10 + root.val;
            return;
        }
        
        traverse(root.left, parentval * 10 + root.val);
        traverse(root.right, parentval * 10 + root.val);
    }
}
