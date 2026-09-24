package Z2025.Tree;

import java.util.*;

public class T107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 1. BFS
        // 2. add inner list at head of linkedlist
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(0, list);
        }
        return res;
    }

}
