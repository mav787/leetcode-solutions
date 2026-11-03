package Z2025.Z_Tree;

import java.util.*;

public class T589 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node curr = stack.pop();
            res.add(curr.val);

            int size = curr.children.size();
            for(int i = size - 1; i >= 0; i--){
                stack.push(curr.children.get(i));
            }
        }

        return res;
    }
}
