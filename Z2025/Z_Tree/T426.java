package Z2025.Z_Tree;

import java.util.*;

public class T426 {
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

    class Solution {
        public Node treeToDoublyList(Node root) {
            if(root == null){
                return null;
            }

            Node head = root, tail = root;

            if(root.left != null){
                Node left = root.left;
                root.left = null;

                Node leftHead = treeToDoublyList(left);
                Node leftTail = leftHead.left;

                leftTail.right = root;
                root.left = leftTail;

                head = leftHead;
            }

            if(root.right != null){
                Node right = root.right;
                root.right = null;

                Node rightHead = treeToDoublyList(right);
                Node rightTail = rightHead.left;

                root.right = rightHead;
                rightHead.left = root;

                tail = rightTail;
            }

            head.left = tail;
            tail.right = head;

            return head;
        }
    }
}
