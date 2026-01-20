package old.T500_699;
import java.util.*;
public class T655ii {
    int depth = 0;
    public List<List<String>> printTree(TreeNode root) {
        findDepth(root, 0);
        List<Map<Integer, Integer>> list = new ArrayList<>();
        DFS(root, 0, 0, list);
        int width = (int) Math.pow(2, depth) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<String> row = new ArrayList<>();
            res.add(row);
            Map<Integer, Integer> curMap = list.get(i);
            for (int j = -width; j <= width; j++) {
                if (curMap.containsKey(j)) {
                    row.add(curMap.get(j) + "");
                } else {
                    row.add("");
                }
            }
        }
        return res;
    }
    
    private void DFS(TreeNode node, int level, int pos, List<Map<Integer, Integer>> list) {
        if (node == null) return;
        if (list.size() <= level) {
            list.add(new HashMap<>());
        }
        list.get(level).put(pos, node.val);
        // System.out.println("depth = " + depth + " level = " + level);
        DFS(node.left, level + 1, pos - (int) Math.pow(2, depth - level - 1), list);
        DFS(node.right, level + 1, pos + (int) Math.pow(2, depth - level - 1), list);
    }
    
    private void findDepth(TreeNode node, int curr) {
        if (node == null) return;
        findDepth(node.left, curr + 1);
        depth = Math.max(depth, curr);
        findDepth(node.right, curr + 1);
    }
}