package Z2025.Z_Tree;

import java.util.*;

public class T590 {

    public List<Integer> postorder(Node root) {
        // left, right, root
        // root, right, left
        List<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node curr = stack.pop();
            res.add(0, curr.val);

            for(Node child : curr.children){
                stack.push(child);
            }
        }

        return res;
    }
}
