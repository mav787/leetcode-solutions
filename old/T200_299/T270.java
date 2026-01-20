package old.T200_299;

public class T270 {
	public int closestValue(TreeNode root, double target) {
        if(root == null) return Integer.MIN_VALUE;
        TreeNode curr = root;
        double minErr = Math.abs(root.val - target);
        int res = root.val;
        while(curr != null){
            if(Math.abs(curr.val - target) < minErr){
                minErr = Math.abs(curr.val - target);
                res = curr.val;
            }
            
            if(curr.val > target){
                curr = curr.left;
            }
            else if(curr.val < target){
                curr = curr.right;
            }
            else{
                return curr.val;
            }
        }
        return res;
    }
}
