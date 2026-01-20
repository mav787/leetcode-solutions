package old.T200_299;
import java.util.*;

public class T257 {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null)
            return res;
        traverse(res, root, new StringBuilder());
        return res;
    }
    
    private void traverse(List<String> res, TreeNode root, StringBuilder sb){

        if(root.left == null && root.right == null){
            sb.append(root.val);
            res.add(sb.toString());
            return;
        }
        
        sb.append(root.val).append("->");
        int len = sb.length();
        if(root.left != null){
            traverse(res, root.left, sb);
        }
        
        sb.setLength(len);
        if(root.right != null){
            traverse(res, root.right, sb);
        }
    }
}
