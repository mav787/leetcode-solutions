package Z2025.T100_999;

public class T116 {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        helper(root.left, root.right);
        return root;
    }

    private void helper(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }

        left.next = right;
        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}



