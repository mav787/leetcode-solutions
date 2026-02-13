package Z2025.T100_999;

public class T230 {
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = count(root.left);
        if(leftCount == k - 1){
            return root.val;
        }
        else if(leftCount > k - 1){
            return kthSmallest(root.left, k);
        }
        else{
            return kthSmallest(root.right, k - leftCount - 1);
        }
    }

    private int count(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + count(root.left) + count(root.right);
    }
}
