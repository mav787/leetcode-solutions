package Z2025.T100_999;

public class T105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){
        if(prestart == preend){
            return new TreeNode(preorder[prestart]);
        }

        if(prestart > preend){
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);

        int index = instart;
        while(index <= inend){
            if(inorder[index] == root.val){
                break;
            }
            index++;
        }

        // left subtree count: [instart, index - 1]
        // count = index - instart

        root.left = helper(preorder, prestart + 1, prestart + index - instart, inorder, instart, index - 1);
        root.right = helper(preorder, prestart + index - instart + 1, preend, inorder, index + 1, inend);
        return root;
    }
}
