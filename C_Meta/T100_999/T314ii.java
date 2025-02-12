package C_Meta.T100_999;
import java.util.*;

public class T314ii {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();

        Map<Integer, List<Integer>> dict = new HashMap<>();
        Map<TreeNode, Integer> map = new HashMap<>();

        map.put(root, 0);
        bfs(root, dict, map);

        Set<Integer> keySet = dict.keySet();

        List<Integer> keys = new ArrayList<>(keySet);
        Collections.sort(keys);

        List<List<Integer>> res = new ArrayList<>();
        for(int key : keys){
            res.add(dict.get(key));
        }

        return res;
    }


    private void bfs(TreeNode node, Map<Integer, List<Integer>> dict, Map<TreeNode, Integer> map){
        if(node == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(node);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                int key = map.get(curr);

                addToDict(dict, curr, key);

                if(curr.left != null){
                    queue.offer(curr.left);
                    map.put(curr.left, key - 1);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                    map.put(curr.right, key + 1);
                }
            }
        }
    }


    private void addToDict(Map<Integer, List<Integer>> dict, TreeNode node, int key){
        List<Integer> list = dict.getOrDefault(key, new ArrayList<Integer>());
        list.add(node.val);
        dict.put(key, list);
    }
}