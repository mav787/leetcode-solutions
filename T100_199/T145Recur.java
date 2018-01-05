package T100_199;
import java.util.*;

public class T145Recur {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        postorderTraversal(root, res);
        return res;
    }
	
	private void postorderTraversal(TreeNode root, List<Integer> res){
		if(root == null) return;
		postorderTraversal(root.left, res);
		postorderTraversal(root.right, res);
		res.add(root.val);
	}
}
