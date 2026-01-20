package Z2025.T10_99;

public class T98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }

        return helper(root.left, min, (long)root.val) && helper(root.right, (long)root.val, max);
    }
}
