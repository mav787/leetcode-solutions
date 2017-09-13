package T500_699;

public class T671 {
	public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left != null && root.right != null) {
            int val = root.val;
            if (root.left.val == val && root.right.val == val) {
                int leftMin = findSecondMinimumValue(root.left);
                int rightMin = findSecondMinimumValue(root.right);
                if (leftMin == -1 && rightMin == -1) return -1;
                if (leftMin == -1) return rightMin;
                if (rightMin == -1) return leftMin;
                return Math.min(leftMin, rightMin);
            }
            else if (root.left.val == val) {
                int leftMin = findSecondMinimumValue(root.left);
                if (leftMin == -1) return root.right.val;
                return Math.min(leftMin, root.right.val);
            }
            else {
                int rightMin = findSecondMinimumValue(root.right);
                if (rightMin == -1) return root.left.val;
                return Math.min(root.left.val, rightMin);
            }
        }
        return -1;
    }
}
