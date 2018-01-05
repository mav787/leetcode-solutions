package T100_199;

public class T106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length){
        	return null;
        }
        return buildTree(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int[] postorder, int postcurr, int instart, int inend){
        if(postcurr < 0 || instart > inend) return null;
        int rootval = postorder[postcurr];
        TreeNode root = new TreeNode(rootval);
        int incurr = 0;
        for(int i = instart; i <= inend; i++){
            if(inorder[i] == rootval){
                incurr = i;
                break;
            }
        }
        root.left = buildTree(inorder, postorder, postcurr - (inend - incurr + 1), instart, incurr - 1);
        root.right = buildTree(inorder, postorder, postcurr - 1, incurr + 1, inend);
        return root;
    }
}
