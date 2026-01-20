package old.C_Meta;

public class TTT543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int candidateFromChildren = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        int longestPath = maxDepth(root.left) + maxDepth(root.right);
        return Math.max(candidateFromChildren, longestPath);
    }

    private int maxDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
