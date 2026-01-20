package old.T200_299;
import java.util.*;
public class T230 {
	public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<Integer>();
        inorderTraverse(root, list);
        return list.get(k - 1);
    }
    
    private void inorderTraverse(TreeNode node, List<Integer> list){
        if(node == null)
            return;
        inorderTraverse(node.left, list);
        list.add(node.val);
        inorderTraverse(node.right, list);
    }
}
