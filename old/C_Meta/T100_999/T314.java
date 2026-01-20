package old.C_Meta.T100_999;
import java.util.*;

public class T314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Map<Integer, List<Integer>> map = new TreeMap<>();

        // 1. traverse the tree
        bfs(root, map);

        // 2. output from treemap
        res = output(map);
        return res;
    }

    private void bfs(TreeNode root, Map<Integer, List<Integer>> map){
        Queue<BetterNode> queue = new LinkedList<>();
        queue.offer(new BetterNode(root, 0));

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                BetterNode node = queue.poll();
                TreeNode curr = node.node;
                int index = node.index;

                List<Integer> list = map.getOrDefault(index, new ArrayList<Integer>());
                list.add(curr.val);
                map.put(index, list);

                if(curr.left != null){
                    queue.offer(new BetterNode(curr.left, index - 1));
                }
                if(curr.right != null){
                    queue.offer(new BetterNode(curr.right, index + 1));
                }
            }
        }
    }

    private List<List<Integer>> output(Map<Integer, List<Integer>> map){
        List<List<Integer>> res = new ArrayList<>();
        for(int key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }

    class BetterNode{
        TreeNode node;
        int index;
        public BetterNode(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
}

