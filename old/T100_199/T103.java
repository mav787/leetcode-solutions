package old.T100_199;
import java.util.*;


public class T103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean order = true;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(order){
                    level.add(node.val);
                }
                else{
                    level.add(0, node.val);
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            order = !order;
            res.add(level);
        }
        return res;
    }
}
