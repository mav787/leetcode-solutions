package Z2025.T100_999;

public class T889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        if(n == 0){
            return null;
        }
        return helper(preorder, 0, n - 1, postorder, 0, n - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
        if(preStart > preEnd){
            return null;
        }
        if(preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        // pre: [preStart + 1, preEnd]
        // post: [postStart, postEnd - 1]

        // find i, that divides left subtree and right subtree
        int i = 1;
        for(i = 1; preStart + i <= preEnd; i++){
            if(postorder[postStart + i - 1] == preorder[preStart + 1]){
                break;
            }
            // left [preStart + 1, preStart + i] [postStart, postStart + i - 1]
            // right [preStart + i + 1, preEnd] [postStart + i, postEnd - 1]
        }

        root.left = helper(preorder, preStart + 1, preStart + i, postorder, postStart, postStart + i - 1);
        root.right = helper(preorder, preStart + i + 1, preEnd, postorder, postStart + i, postEnd - 1);
        return root;
    }
}
