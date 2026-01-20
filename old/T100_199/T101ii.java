package old.T100_199;
import java.util.*;

public class T101ii {
	public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }
}
