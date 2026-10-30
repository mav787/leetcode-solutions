package Z2025.Z_Tree;

import java.util.*;

public class T449 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null){
                return "";
            }

            return root.val + "," + serialize(root.left) + serialize(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.isEmpty()){
                return null;
            }

            String[] sa = data.split(",");

            int[] index = new int[1];
            return helper(sa, index, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private TreeNode helper(String[] sa, int[] index, long min, long max){
            if(index[0] >= sa.length){
                return null;
            }

            int val = Integer.valueOf(sa[index[0]]);
            if(val <= min || val >= max){
                return null;
            }

            index[0]++;
            TreeNode root = new TreeNode(val);
            root.left = helper(sa, index, min, val);
            root.right = helper(sa, index, val, max);

            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
}
