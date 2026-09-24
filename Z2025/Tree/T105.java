package Z2025.Tree;

import java.util.*;

public class T105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd){
            return null;
        }

        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);

        int index = inStart;
        for(int i = index; i <= inEnd; i++){
            if(inorder[i] == val){
                index = i;
                break;
            }
        }

        int leftLen = (index - 1) - inStart + 1;

        root.left = helper(preorder, preStart + 1, preStart + 1 + leftLen - 1, inorder, inStart, index - 1);
        root.right = helper(preorder, preStart + 1 + leftLen, preEnd, inorder, index + 1, inEnd);

        return root;
    }

}
