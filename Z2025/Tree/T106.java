package Z2025.Tree;

import java.util.*;

public class T106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length){
            return null;
        }

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd){
            return null;
        }

        int val = postorder[postEnd];
        TreeNode root = new TreeNode(val);

        int index = inEnd;
        for(int i = inEnd; i >= inStart; i--){
            if(inorder[i] == val){
                index = i;
                break;
            }
        }

        int rightCount = inEnd - (index + 1) + 1;
        root.left = helper(inorder, inStart, index - 1, postorder, postStart, postEnd - 1 - rightCount);
        root.right = helper(inorder, index + 1, inEnd, postorder, postEnd - rightCount, postEnd - 1);
        return root;
    }
}
