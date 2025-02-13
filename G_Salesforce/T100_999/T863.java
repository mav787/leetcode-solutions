package G_Salesforce.T100_999;
import java.util.*;

public class T863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // graph problem
        // 1. traverse tree, build graph
        // 2. traverse graph from target, find all neighbors with distance == k

        List<TreeNode> nodes = new ArrayList<>();
        if(root == null || target == null || k < 0){
            return new ArrayList<Integer>();
        }

        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();

        traverse(root, map);

        search(target, map, k, nodes, set);

        List<Integer> res = new ArrayList<>();
        for(TreeNode node : nodes){
            res.add(node.val);
        }
        return res;
    }


    private void search(TreeNode curr,
                        Map<TreeNode, List<TreeNode>> map,
                        int k,
                        List<TreeNode> res,
                        Set<TreeNode> set)
    {
        if(k == 0){
            res.add(curr);
            return;
        }
        set.add(curr);
        if(map.containsKey(curr)){
            List<TreeNode> neighbors = map.get(curr);
            for(TreeNode neighbor : neighbors){
                if(!set.contains(neighbor)){
                    search(neighbor, map, k - 1, res, set);
                }
            }
        }
    }


    private void traverse(TreeNode root, Map<TreeNode, List<TreeNode>> map){
        if(root == null){
            return;
        }

        if(root.left != null){
            buildEdge(root, root.left, map);
            traverse(root.left, map);
        }

        if(root.right != null){
            buildEdge(root, root.right, map);
            traverse(root.right, map);
        }
    }

    private void buildEdge(TreeNode parent, TreeNode child, Map<TreeNode, List<TreeNode>> map){
        if(parent == null || child == null){
            return;
        }

        helper(parent, child, map);
        helper(child, parent, map);
    }

    private void helper(TreeNode t1, TreeNode t2, Map<TreeNode, List<TreeNode>> map){
        List<TreeNode> list = map.getOrDefault(t1, new ArrayList<>());
        list.add(t2);
        map.put(t1, list);
    }
}
