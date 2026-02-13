package Z2025.T100_999;

public class T222 {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int depth = getDepth(root);
        int rightDepth = getRightDepth(root);
        if(depth == rightDepth){
            return (1 << depth) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getDepth(TreeNode root){
        int res = 0;
        while(root != null){
            res++;
            root = root.left;
        }

        return res;
    }

    private int getRightDepth(TreeNode root){
        int res = 0;
        while(root != null){
            res++;
            root = root.right;
        }

        return res;
    }
}
