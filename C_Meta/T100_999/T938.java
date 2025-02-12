package C_Meta.T100_999;

public class T938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }

        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);

        int curr = root.val >= low && root.val <= high ? root.val : 0;
        return left + curr + right;
    }
}
