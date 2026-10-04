package Z2025.Tree;

import java.util.*;

public class T297 {
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
                return "#";
            }

            StringBuilder sb = new StringBuilder();
            sb.append(root.val).append(",");
            sb.append(serialize(root.left)).append(",");
            sb.append(serialize(root.right)).append(",");
            sb.setLength(sb.length() - 1);

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] sa = data.split(",");
            return helper(sa, 0).node;
        }

        private Helper helper(String[] sa, int index){
            if(index >= sa.length){
                return null;
            }
            String s = sa[index];

            TreeNode root = getNode(s);
            index++;
            if(root == null){
                return new Helper(null, index);
            }


            Helper left = helper(sa, index);
            Helper right = helper(sa, left.cursor);

            root.left = left.node;
            root.right = right.node;

            return new Helper(root, right.cursor);
        }

        private TreeNode getNode(String s){
            if(s.equals("#")){
                return null;
            }
            return new TreeNode(Integer.valueOf(s));
        }

    }

    class Helper{
        TreeNode node;
        int cursor;

        public Helper(TreeNode node, int cursor){
            this.node = node;
            this.cursor = cursor;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
