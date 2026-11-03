package Z2025.Z_Tree;

import java.util.*;

public class T536 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public TreeNode str2tree(String s) {
            if(s == null){
                return null;
            }
            return helper(s, 0, s.length() - 1);
        }

        private TreeNode helper(String s, int start, int end){
            if(start > end){
                return null;
            }

            int i = start;
            boolean isNegative = false;
            int val = 0;

            if(s.charAt(i) == '-'){
                isNegative = true;
                i++;
            }

            for(i = i; i <= end; i++){
                char c = s.charAt(i);
                if(c >= '0' && c <= '9'){
                    val = val * 10 + c - '0';
                }
                else{
                    break;
                }
            }

            if(isNegative){
                val = -val;
            }

            TreeNode root = new TreeNode(val);

            int j = i;
            int depth = 0;
            for(j = j; j <= end; j++){
                char c = s.charAt(j);

                if(c == '('){
                    depth++;
                }
                else if(c ==')'){
                    depth--;
                    if(depth == 0){
                        root.left = helper(s, i + 1, j - 1);
                        root.right = helper(s, j + 2, end - 1);
                        return root;
                    }
                }
            }

            return root;
        }
    }
}
