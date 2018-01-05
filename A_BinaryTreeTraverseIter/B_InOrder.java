package A_BinaryTreeTraverseIter;
import java.util.*;

public class B_InOrder {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}






















class TreeNode {
	 public int val;
	 public TreeNode left, right;
	 
	 public TreeNode(int val) {
		 this.val = val;
	     this.left = this.right = null;
	 }
}