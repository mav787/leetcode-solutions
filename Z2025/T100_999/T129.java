package Z2025.T100_999;

public class T129 {
    public int sumNumbers(TreeNode root) {
        int[] res = new int[]{0};
        helper(root, res, 0);
        return res[0];
    }

    private void helper(TreeNode root, int[] res, int curr){
        if(root == null){
            return;
        }

        int val = curr * 10 + root.val;
        if(root.left == null && root.right == null){
            res[0] += val;
            return;
        }

        helper(root.left, res, val);
        helper(root.right, res, val);
    }
}
