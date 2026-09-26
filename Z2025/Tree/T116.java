package Z2025.Tree;

import java.util.*;

public class T116 {

// Definition for a Node.



    class Solution {
        public Node connect(Node root) {
            return helper(root, null);
        }

        private Node helper(Node root, Node next){
            if(root == null){
                return root;
            }

            root.next = next;
            helper(root.left, root.right);

            if(next != null){
                helper(root.right, next.left);
                helper(next.left, next.right);
            }

            return root;
        }
    }

}
