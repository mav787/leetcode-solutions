package T500_699;
import java.util.*;

public class T652 {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";  
        // represent the tree structure as a string.
        String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
        if(!map.containsKey(serial)) 
        	map.put(serial, 0);
        if (map.get(serial) <= 1) {
            if (map.get(serial) == 1) 
            	res.add(cur);
            map.put(serial, map.get(serial) + 1);
        }
        return serial;
    }
}
