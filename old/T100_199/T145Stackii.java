package old.T100_199;
import java.util.*;

//import BinaryTreeTraverseIter.TreeNode;

public class T145Stackii {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode curr = root;
        
        while(curr != null){
        	stack.push(curr);
        	curr = curr.left;
        }
        while(!stack.isEmpty()) {
            curr = stack.peek();
            if(curr.right != null && curr.right != pre){	// going down
            	curr = curr.right;
            	while(curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
            }
            
            else{											// going up
                curr = stack.pop();
                res.add(curr.val);
                pre = curr;
                curr = null;
            }
        }
        return res;
    }
}
