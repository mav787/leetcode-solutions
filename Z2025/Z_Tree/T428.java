package Z2025.Z_Tree;

import java.util.*;

public class T428 {
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
                return "[]";
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[").append(root.val);

            if(root.children != null && !root.children.isEmpty()){
                sb.append("[");
                for(Node child : root.children){
                    sb.append(serialize(child)).append(",");
                }

                sb.setLength(sb.length() - 1);
                sb.append("]");
            }
            sb.append("]");
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            return helper(data, 0, data.length() - 1);
        }

        private Node helper(String data, int start, int end){
            if(start + 1 >= end){
                return null;
            }

            int i = start + 1;
            boolean isNegative = false;
            if(data.charAt(i) == '-'){
                isNegative = true;
                i++;
            }

            int value = 0;
            for(i = i; i < end; i++){
                char c = data.charAt(i);
                if(c >= '0' && c <= '9'){
                    value = value * 10 + c - '0';
                }
                else{
                    break;
                }
            }

            value = isNegative? -value : value;
            Node root = new Node(value);

            root.children = new ArrayList<>();
            int childStart = i + 1;

            int depth = 0;
            for(int j = i + 1; j < end - 1; j++){
                char c = data.charAt(j);
                if(c == '['){
                    depth++;
                }
                else if(c == ']'){
                    depth--;
                }

                if(depth == 0 && c == ']'){
                    root.children.add(helper(data, childStart, j));
                    // j == ']', j + 1 == ',', j + 2 == '['
                    childStart = j + 2;
                }
            }

            return root;
        }
    }

}
