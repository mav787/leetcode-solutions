package old.C_Meta.T100_999;

public class T938II {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }

        if(root.val < low){
            return rangeSumBST(root.right, low, high);
        }
        else if(root.val > high){
            return rangeSumBST(root.left, low, high);
        }
        else{
            int left = rangeSumBST(root.left, low, high);
            int right = rangeSumBST(root.right, low, high);
            return left + right + root.val;
        }
    }
}
