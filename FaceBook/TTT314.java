package FaceBook;
import java.util.*;

public class TTT314 {
private int minpos = 0, maxpos = 0;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        traverse(root, map);
        constructList(map, res);
        return res;
    }
    
    private void traverse(TreeNode root, Map<Integer, List<Integer>> map){
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> dict = new HashMap<>();
        queue.offer(root);
        dict.put(root, 0);
    
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int pos = dict.get(node);
            
            minpos = Math.min(minpos, pos);
            maxpos = Math.max(maxpos, pos);
            
            if(!map.containsKey(pos)){
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(pos, list);
            }
            else{
                map.get(pos).add(node.val);
            }
            
            if(node.left != null){
                queue.offer(node.left);
                dict.put(node.left, pos - 1);
            }
            if(node.right != null){
                queue.offer(node.right);
                dict.put(node.right, pos + 1);
            }
        }
    }
    
    private void constructList(Map<Integer, List<Integer>> map, List<List<Integer>> res){
        for(int i = minpos; i <= maxpos; i++){
            if(map.containsKey(i)){
                List<Integer> list = map.get(i);
                res.add(list);
            }
        }
    }
}
