package Z2025.T10_99;
import java.util.*;

public class T95 {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private List<TreeNode> helper(int lower, int upper){
        List<TreeNode> res = new ArrayList<>();
        if(lower > upper){
            res.add(null);
            return res;
        }

        if(lower == upper){
            TreeNode node = new TreeNode(lower);
            res.add(node);
            return res;
        }

        for(int i = lower; i <= upper; i++){
            List<TreeNode> lefts = helper(lower, i - 1);
            List<TreeNode> rights = helper(i + 1, upper);

            for(TreeNode left : lefts){
                for(TreeNode right : rights){
                    TreeNode root = new TreeNode(i, left, right);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
