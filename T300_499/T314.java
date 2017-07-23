package T300_499;
import java.util.*;

public class T314 {
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<TreeNode, Integer> dict = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        dict.put(root, 0);
        int minKey = 0, maxKey = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int num = dict.get(node);
            minKey = Math.min(minKey, num);
            maxKey = Math.max(maxKey, num);
            if(!map.containsKey(num))
                map.put(num, new ArrayList<Integer>());
            map.get(num).add(node.val);
            
            if(node.left != null){
                queue.offer(node.left);
                dict.put(node.left, num - 1);
            }
            
            if(node.right != null){
                queue.offer(node.right);
                dict.put(node.right, num + 1);
            }
        }
        
        for(int i = minKey; i <= maxKey; i++){
            if(map.containsKey(i))
                res.add(map.get(i));
        }
        return res;
    }
}
