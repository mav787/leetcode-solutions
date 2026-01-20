package old.T500_699;
import java.util.*;
public class T653 {
	public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        int left = 0, right = list.size() - 1;
        while(left < right){
            int sum = list.get(left) + list.get(right);
            if(sum < k){
                left++;
            }
            else if(sum > k){
                right--;
            }
            else{
                return true;
            }
        }
        return false;
    }
    
    private void traverse(TreeNode root, List<Integer> list){
        if(root == null) return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}
