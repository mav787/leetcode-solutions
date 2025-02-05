package C_Meta;
import java.util.*;

public class TTT314 {
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> index = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        index.offer(0);
        
        int minKey = 0, maxKey = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int num = index.poll();
            minKey = Math.min(minKey, num);
            maxKey = Math.max(maxKey, num);
            if(!map.containsKey(num)){
                map.put(num, new ArrayList<Integer>());
            }  
            map.get(num).add(node.val);
            
            if(node.left != null){
                queue.offer(node.left);
                index.offer(num - 1);
            }
            
            if(node.right != null){
                queue.offer(node.right);
                index.offer(num + 1);
            }
        }
        
        for(int i = minKey; i <= maxKey; i++){
            if(map.containsKey(i)){
                res.add(map.get(i));
            } 
        }
        return res;
    }
}
