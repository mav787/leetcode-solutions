package Z2025.T100_999;

import java.util.*;

public class T298 {
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }

        return helper(root, null, 0);
    }

    private int helper(TreeNode node, TreeNode parent, int length){
        if(node == null){
            return 0;
        }

        if(parent != null && parent.val + 1 == node.val){
            length++;
        }
        else{
            length = 1;
        }

        int left = helper(node.left, node, length);
        int right = helper(node.right, node, length);

        return Math.max(length, Math.max(left, right));
    }
}
