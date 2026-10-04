package Z2025.Tree;

import java.util.*;

public class T222 {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = getLeft(root);
        int right = getRight(root);

        if(left == right){
            return (int)(Math.pow(2, left)) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeft(TreeNode root){
        int res = 0;
        while(root != null){
            res++;
            root = root.left;
        }
        return res;
    }

    private int getRight(TreeNode root){
        int res = 0;
        while(root != null){
            res++;
            root = root.right;
        }
        return res;
    }
}
