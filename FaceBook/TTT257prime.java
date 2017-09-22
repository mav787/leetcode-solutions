package FaceBook;
import java.util.*;
public class TTT257prime {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null)
            return res;
        if(root.left == null && root.right == null){
            res.add(root.val + "");
            return res;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        for(String s : left){
            res.add(root.val + "->" + s);
        }
        for(String s : right){
            res.add(root.val + "->" + s);
        }
        return res;
    }
}
