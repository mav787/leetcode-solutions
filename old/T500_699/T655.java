package old.T500_699;
import java.util.*;

public class T655 {
	public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if(root == null)
            return res;
        int m = depth(root);
        int n = (int)Math.pow(2, m) - 1;
        for(int i = 0; i < m; i++){
        	List<String> level = new ArrayList<>();
            for(int j = 0; j < n; j++){
                level.add("");
            }
            res.add(level);
        }
        
        dfs(res, root, 0, 0, n - 1);
        return res;
    }
    
    private void dfs(List<List<String>> res, TreeNode root, int depth, int left, int right){
        if(root == null) return;
        int i = depth;
        int j = left + (right - left) / 2;
        res.get(i).set(j, String.valueOf(root.val));
        dfs(res, root.left, i + 1, left, j - 1);
        dfs(res, root.right, i + 1, j + 1, right);
    }
    
    private int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}