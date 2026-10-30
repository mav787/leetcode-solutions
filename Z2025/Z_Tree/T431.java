package Z2025.Z_Tree;

import java.util.*;

public class T431 {
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    class Codec {
        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if(root == null){
                return null;
            }

            TreeNode newRoot = new TreeNode(root.val);

            if(root.children.size() > 0){
                Node firstChild = root.children.get(0);
                TreeNode encoded = encode(firstChild);
                newRoot.left = encoded;
                for(int i = 1; i < root.children.size(); i++){
                    encoded.right = encode(root.children.get(i));
                    encoded = encoded.right;
                }
            }

            return newRoot;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if(root == null){
                return null;
            }

            Node newRoot = new Node(root.val);
            newRoot.children = new ArrayList<>();

            TreeNode firstChild = root.left;


            while(firstChild != null){
                Node decoded = decode(firstChild);
                newRoot.children.add(decoded);

                firstChild = firstChild.right;
            }

            return newRoot;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));
}
