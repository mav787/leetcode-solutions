package G_Salesforce.T100_999;

public class T124 {
    Integer max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        traverse(root);
        return max;
    }


    private int traverse(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = Math.max(traverse(root.left), 0);
        int right = Math.max(traverse(root.right), 0);

        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
