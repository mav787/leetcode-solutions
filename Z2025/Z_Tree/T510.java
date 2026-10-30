package Z2025.Z_Tree;

import java.util.*;

public class T510 {
    public Node inorderSuccessor(Node node) {
        if(node == null){
            return null;
        }
        if(node.right != null){
            Node curr = node.right;
            while(curr.left != null){
                curr = curr.left;
            }
            return curr;
        }
        else{
            Node curr = node;
            while(curr.parent != null && curr.parent.right == curr){
                curr = curr.parent;
            }

            return curr.parent;
        }
    }
}
