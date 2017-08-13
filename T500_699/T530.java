package T500_699;
import java.util.*;

public class T530 {
	public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        if(list.size() < 2) return 0;
        int res = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++){
            res = Math.min(res, list.get(i) - list.get(i - 1));    
        }
        return res;
    }
    
    private void traverse(TreeNode root, List<Integer> list){
        if(root == null) return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}
