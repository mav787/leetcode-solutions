package old.T300_499;

import java.util.*;

public class T366 {
	
//	The essential of problem is not to find the leaves, but group leaves of same level 
//	together and also to cut the tree. This is the exact role backtracking plays. 
//	The helper function returns the level which is the distance from its furthest 
//	subtree leaf to root, which helps to identify which group the root belongs to
	
	
//	The key is to find the height of each node. Here the definition of height is:
//	The height of a node is the number of edges from the node to the deepest leaf. 
		
//	The height of a node is also the its index in the result list (res). For example, 
//	leaves, whose heights are 0, are stored in res[0]. Once we find the height of a 
//	node, we can put it directly into the result.
	
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        findLeavesHelper(list, root);
        return list;
    }
    
// return the level of root
    private int findLeavesHelper(List<List<Integer>> list, TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftLevel = findLeavesHelper(list, root.left);
        int rightLevel = findLeavesHelper(list, root.right);
        int level = Math.max(leftLevel, rightLevel) + 1;
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        //root.left = root.right = null;
        return level;
    }
}
