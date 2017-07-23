package T100_199;
import java.util.*;


public class T103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean inorder = true;
        while(!stack.isEmpty()){
            int size = stack.size();
            List<TreeNode> level = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = stack.pop();
                level.add(node);
                values.add(node.val);
            }
            
            res.add(values);
            if(inorder){
                for(int i = 0; i < size; i++){
                    TreeNode node = level.get(i);
                    if(node.left != null)
                        stack.push(node.left);
                    if(node.right != null)
                        stack.push(node.right);
                }
                inorder = false;
            }
            else{
                for(int i = 0; i < size; i++){
                    TreeNode node = level.get(i);
                    if(node.right != null)
                        stack.push(node.right);
                    if(node.left != null)
                        stack.push(node.left);
                }
                inorder = true;
            }
        }
        return res;
    }
}
