package Z2025.Z_Tree;

public class T230 {
    public int kthSmallest(TreeNode root, int k) {
        int kk = k - 1;

        if(root == null){
            return -1;
        }

        int count = count(root.left);
        if(count > kk){
            return kthSmallest(root.left, k);
        }
        else if(count == kk){
            return root.val;
        }
        else{
            return kthSmallest(root.right, k - count - 1);
        }
    }


    private int count(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + count(root.left) + count(root.right);
    }
}
