package T100_199;
import java.util.*;

public class T144 {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        preorderTraversal(root, res);
        return res;
    }
    
    private void preorderTraversal(TreeNode root, List<Integer> res){
        if(root == null)
            return;
        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }
}
