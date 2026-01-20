package old.T200_299;
import java.util.*;

public class T257Verbose {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null)
            return res;
        backtrack(res, root, new StringBuilder());
        return res;
    }
    
    private void backtrack(List<String> res, TreeNode root, StringBuilder sb){
        if (root == null)
            return;
        if(root.left == null && root.right == null){
            sb.append("" + root.val);
            res.add(sb.toString());
            return;
        }
        
        sb.append(root.val + "->");
        int len = sb.length();
        backtrack(res, root.left, sb);
        sb.setLength(len);
        backtrack(res, root.right, sb);
        // sb.setLength(len);
    }
}
