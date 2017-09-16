package T200_299;

public class T222ii {
	public int countNodes(TreeNode root) {
        int num = 0;
        int leftHeight = height(root) - 1;
        while (root != null) {
            
            int rightHeight = height(root.right);
            if (leftHeight == rightHeight) {
                root = root.right;
                num += (1 << leftHeight);
            } else {
                root = root.left;
                num += (1 << rightHeight);
            }
            leftHeight--;
        }
        return num;
    }
    
    private int height(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
}
