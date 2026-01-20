package old.T100_199;
import java.util.*;

public class T113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), root, sum);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum){
        if(root == null)
            return;
        if(root.left == null && root.right == null && sum == root.val){
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        
        path.add(root.val);
        backtrack(res, path, root.left, sum - root.val);
        backtrack(res, path, root.right, sum - root.val);
        path.remove(path.size() - 1);
        
    }
}
