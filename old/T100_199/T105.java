package old.T100_199;

public class T105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length)
            return null;
        return buildTree(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    private TreeNode buildTree(int prestart, int instart, int inend, int[] preorder, int[] inorder){
        if(prestart >= preorder.length || instart > inend)
            return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int incurr = 0;
        for(int i = instart; i <= inend; i++){
            if(inorder[i] == preorder[prestart]){
                incurr = i;
                break;
            }
        }
        root.left = buildTree(prestart + 1, instart, incurr - 1, preorder, inorder);
        root.right = buildTree(prestart + incurr - instart + 1, incurr + 1, inend, preorder, inorder);
        return root;
    }
}
