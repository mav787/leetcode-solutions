package Z2025.Tree;

import java.util.*;

public class T496 {


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
    }


    class Codec {

        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if(root == null){
                return "#";
            }

            StringBuilder sb = new StringBuilder();
            sb.append(root.val);

            if(root.children == null || root.children.size() == 0){
                return sb.toString();
            }

            sb.append("[");
            for(Node node : root.children){
                sb.append(serialize(node)).append(",");
            }

            sb.setLength(sb.length() - 1);
            sb.append("]");

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if(data.equals("#")){
                return null;
            }

            int[] curr = new int[1];
            return helper(data, curr);
        }

        private Node helper(String data, int[] curr) {
            int sign = 1;

            if(data.charAt(curr[0]) == '-'){
                sign = -1;
                curr[0]++;
            }

            int val = 0;
            while(curr[0] < data.length() &&
                    Character.isDigit(data.charAt(curr[0]))){
                val = val * 10 + data.charAt(curr[0]) - '0';
                curr[0]++;
            }

            Node root = new Node(sign * val, new ArrayList<>());

            if(curr[0] == data.length() || data.charAt(curr[0]) != '['){
                return root;
            }

            // skip '['
            curr[0]++;

            while(data.charAt(curr[0]) != ']'){
                Node child = helper(data, curr);
                root.children.add(child);

                if(data.charAt(curr[0]) == ','){
                    curr[0]++;
                }
            }

            // skip ']'
            curr[0]++;

            return root;
        }
    }
}
