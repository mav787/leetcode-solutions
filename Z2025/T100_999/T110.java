package Z2025.T100_999;

public class T110 {
    // public boolean isBalanced(TreeNode root) {
    //     if(root == null){
    //         return true;
    //     }
    //     return isBalanced(root.left) && isBalanced(root.right) && Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
    // }

    // private int getDepth(TreeNode root){
    //     if(root == null){
    //         return 0;
    //     }

    //     return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    // }


    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    private Result helper(TreeNode root){
        if(root == null){
            return new Result(true, 0);
        }

        Result left = helper(root.left);
        Result right = helper(root.right);

        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.depth - right.depth) <= 1;
        int depth = 1 + Math.max(left.depth, right.depth);
        return new Result(isBalanced, depth);
    }



    class Result{
        boolean isBalanced;
        int depth;
        public Result(boolean isBalanced, int depth){
            this.isBalanced = isBalanced;
            this.depth = depth;
        }
    }
}
