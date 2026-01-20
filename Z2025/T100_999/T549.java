package Z2025.T100_999;

public class T549 {
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = longestConsecutive(root.left);
        int right = longestConsecutive(root.right);
        int mustThroughRoot = helper(root);

        return Math.max(Math.max(left, right), mustThroughRoot);
    }

    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int inc = getDiff(root, root.left, -1) + 1 + getDiff(root, root.right, 1);
        int dec = getDiff(root, root.left, 1) + 1 + getDiff(root, root.right, -1);

        return Math.max(inc, dec);
    }

    private int getDiff(TreeNode root, TreeNode child, int diff){
        if(child == null || child.val != root.val + diff){
            return 0;
        }

        return 1 + Math.max(getDiff(child, child.left, diff), getDiff(child, child.right, diff));
    }
}
