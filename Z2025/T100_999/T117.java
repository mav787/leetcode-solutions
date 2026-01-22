package Z2025.T100_999;
import java.util.*;


public class T117 {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            Node pre = null, curr = null;
            for(int i = 0; i < size; i++){
                pre = curr;
                curr = queue.poll();
                if(pre != null){
                    pre.next = curr;
                }

                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
        }

        return root;
    }
}
