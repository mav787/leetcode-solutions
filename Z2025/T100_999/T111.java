package Z2025.T100_999;

public class T111 {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null)
            return minDepth(root.right) + 1;
        if(root.right == null)
            return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
