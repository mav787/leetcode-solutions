package Z2025.T100_999;

public class T124 {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        helper(root, res);
        return res[0];
    }

    // updates res[0], returns the max sum, passing root
    private int helper(TreeNode root, int[] res){
        if(root == null){
            return 0;
        }

        int left = Math.max(helper(root.left, res), 0);
        int right = Math.max(helper(root.right, res), 0);

        int result = root.val + Math.max(left, right);
        res[0] = Math.max(res[0], root.val + left + right);
        return result;
    }
}
