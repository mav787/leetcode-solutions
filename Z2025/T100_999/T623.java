package Z2025.T100_999;

public class T623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            return new TreeNode(val, root, null);
        }

        dfs(root, val, depth, 1);
        return root;
    }

    private void dfs(TreeNode root, int val, int depth, int curr){
        if(root == null){
            return;
        }

        if(curr == depth - 1){
            TreeNode left = root.left;
            root.left = new TreeNode(val, left, null);

            TreeNode right = root.right;
            root.right = new TreeNode(val, null, right);
        }

        else{
            dfs(root.left, val, depth, curr + 1);
            dfs(root.right, val, depth, curr + 1);
        }
    }
}
