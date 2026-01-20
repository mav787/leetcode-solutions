package old.T500_699;
import java.util.*;
public class T662 {
	
	public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        
        int res = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root, 0);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                int index = map.get(node);
                left = Math.min(left, index);
                right = Math.max(right, index);
                if(node.left != null){
                    queue.offer(node.left);
                    map.put(node.left, 2 * index);
                }
                if(node.right != null){
                    queue.offer(node.right);
                    map.put(node.right, 2 * index + 1);
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
