package T500_699;

public class T563My {
	public int findTilt(TreeNode root) {
        if(root == null) return 0;
        int left = findTilt(root.left);
        int right = findTilt(root.right);
        int res = left + right + Math.abs(sum(root.left) - sum(root.right));
        return res;
    }
    
    private int sum(TreeNode root){
        if(root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}
