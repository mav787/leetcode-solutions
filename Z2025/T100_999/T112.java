package Z2025.T100_999;

public class T112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 1. 空树处理
        if (root == null) {
            return false;
        }

        // 2. 到达叶子节点，判断剩余的 targetSum 是否等于当前节点的值
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // 3. 递归检查左右子树，只要有一条路径满足即可
        // 这里的改动是把 targetSum 减去当前节点值向下传递
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}
