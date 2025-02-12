package C_Meta.T100_999;
import java.util.*;

public class T987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Node>> map = new TreeMap<>();
        traverse(root, map, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for(int key : map.keySet()){
            List<Integer> inner = new ArrayList<>();
            List<Node> list = map.get(key);
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
