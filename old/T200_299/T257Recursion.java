package old.T200_299;
import java.util.*;

public class T257Recursion {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null)
            return res;
        if(root.left == null && root.right == null){
            res.add("" + root.val);
            return res;
        }
        
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        for(String s : left){
            String item = root.val + "->" + s;
            res.add(item);
        }
        for(String s : right){
            String item = root.val + "->" + s;
            res.add(item);
        }
        return res;
    }
}
