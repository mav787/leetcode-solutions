package Z2025.Z_Tree;

import java.util.*;

public class T429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                list.add(node.val);

                for(Node child : node.children){
                    if(child != null){
                        queue.offer(child);
                    }
                }
            }

            res.add(list);
        }

        return res;
    }
}
