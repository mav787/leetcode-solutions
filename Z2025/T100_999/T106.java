package Z2025.T100_999;

public class T106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend){
        if(instart > inend){
            return null;
        }
        if(instart == inend){
            return new TreeNode(inorder[instart]);
        }

        TreeNode root = new TreeNode(postorder[postend]);

        int i = inend;
        while(i >= instart){
            if(inorder[i] == root.val){
                break;
            }

            i--;
        }

        // right subtree node count = inend - i
        // left subtree node count = postend - poststart - inend + i

        root.left = helper(inorder, instart, i - 1, postorder, poststart, postend - inend + i - 1);
        root.right = helper(inorder, i + 1, inend, postorder, postend - inend + i, postend - 1);
        return root;
    }
}
