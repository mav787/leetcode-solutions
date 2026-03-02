package Z2025.T100_999;

public class T250 {
    public int countUnivalSubtrees(TreeNode root) {
        int[] res = new int[1];
        isUnival(root, res);
        return res[0];
    }

    private boolean isUnival(TreeNode root, int[] res){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            res[0]++;
            return true;
        }

        boolean left = isUnival(root.left, res);
        boolean right = isUnival(root.right, res);
        if(left && right
                && (root.left == null || root.val == root.left.val)
                && (root.right == null || root.val == root.right.val))
        {
            res[0]++;
            return true;
        }
        return false;
    }
}
