package Z2025.T100_999;
import java.util.*;

public class T101 {
//    // recur
//    public boolean isSymmetric(TreeNode root) {
//        return helper(root, root);
//    }
//
//    private boolean helper(TreeNode left, TreeNode right){
//        if(left == null && right == null){
//            return true;
//        }
//        if(left == null || right == null || left.val != right.val){
//            return false;
//        }
//
//        return helper(left.left, right.right) && helper(left.right, right.left);
//    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            List<TreeNode> level = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                level.add(node);
            }

            if(!isValidLevel(level)){
                return false;
            }
        }

        return true;
    }

    private boolean isValidLevel(List<TreeNode> level){
        for(int i = 0; i < level.size() / 2; i++){
            TreeNode left = level.get(i);
            TreeNode right = level.get(level.size() - i - 1);

            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null || left.val != right.val){
                return false;
            }
        }

        return true;
    }
}
