package C_Meta.T100_999;
import java.util.*;

public class T987II {
    int min = 0, max = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        traverse(root, map, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        // for(int key : map.keySet()){
        for(int i = min; i <= max; i++){
            if(!map.containsKey(i)){
                continue;
            }
            List<Integer> inner = new ArrayList<>();
            List<Node> list = map.get(i);
            Collections.sort(list, (a, b) -> a.row == b.row ? a.treenode.val - b.treenode.val : a.row - b.row);
            for(Node node : list){
                inner.add(node.treenode.val);
            }
            res.add(inner);
        }
        return res;
    }

    private void traverse(TreeNode root, Map<Integer, List<Node>> map, int r, int c){
        if(root == null){
            return;
        }
        List<Node> list = map.getOrDefault(c, new ArrayList<Node>());
        list.add(new Node(root, r));
        map.put(c, list);

        min = Math.min(min, c);
        max = Math.max(max, c);

        traverse(root.left, map, r + 1, c - 1);
        traverse(root.right, map, r + 1, c + 1);
    }


    class Node{
        TreeNode treenode;
        int row;
        public Node(TreeNode treenode, int row){
            this.treenode = treenode;
            this.row = row;
        }
    }
}
