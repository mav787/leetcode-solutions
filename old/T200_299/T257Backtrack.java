package old.T200_299;
import java.util.*;

public class T257Backtrack {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null)
            return res;
        backtrack(res, root, new StringBuilder());
        return res;
    }
    
    private void backtrack(List<String> res, TreeNode root, StringBuilder sb){
        if(root == null)
            return;
        int len = sb.length();
        if(root.left == null && root.right == null){
            sb.append(root.val);
            res.add(sb.toString());
            sb.setLength(len);
            return;
        }
        
        sb.append(root.val).append("->");
        backtrack(res, root.left, sb);
        sb.setLength(len);
        
        sb.append(root.val).append("->");
        backtrack(res, root.right, sb);
        sb.setLength(len);
    }
}
