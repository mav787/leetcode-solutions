package old.T500_699;
import java.util.*;
public class T538My {
	public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        List<TreeNode> list = new ArrayList<>();
        // inorder : left, root, right
        traverse(root, list);
        
        for(int i = list.size() - 2; i >= 0; i--){
            list.get(i).val += list.get(i + 1).val;    
        }
        
        return root;
    }
    
    private void traverse(TreeNode root, List<TreeNode> list){
        if(root == null) return;
        traverse(root.left, list);
        list.add(root);
        traverse(root.right, list);
    }
}
