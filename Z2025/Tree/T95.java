package Z2025.Tree;

import java.util.*;

public class T95 {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private List<TreeNode> helper(int left, int right){
        List<TreeNode> res = new ArrayList<>();
        if(left > right){
            res.add(null);
            return res;
        }

        for(int i = left; i <= right; i++){
            List<TreeNode> lefts = helper(left, i - 1);
            List<TreeNode> rights = helper(i + 1, right);

            for(TreeNode leftSub : lefts){
                for(TreeNode rightSub : rights){
                    TreeNode root = new TreeNode(i);
                    root.left = leftSub;
                    root.right = rightSub;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
