package A_BinaryTreeTraverseIter;
import java.util.*;

public class B_InOrder {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
    
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