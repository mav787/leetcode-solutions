package T200_299;

public class T270 {
	public int closestValue(TreeNode root, double target) {
        if(root == null)
            return Integer.MAX_VALUE;
        TreeNode curr = root, res = root;
        double minErr = Double.MAX_VALUE;
        while(curr != null){
            double err = Math.abs(curr.val - target);
            if(err < minErr){
                minErr = err;
                res = curr;
            }
            
            if(curr.val < target)
                curr = curr.right;
            else if(curr.val > target)
                curr = curr.left;
            else
                return curr.val;
        }
        return res.val;
    }
}
