package Z2025.T100_999;
import java.util.*;

public class T113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, targetSum, new ArrayList<>());
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int targetSum, List<Integer> list){
        if(root == null){
            return;
        }

        if(root.val == targetSum && root.left == null && root.right == null){
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        list.add(root.val);
        helper(res, root.left, targetSum - root.val, list);
        list.remove(list.size() - 1);

        list.add(root.val);
        helper(res, root.right, targetSum - root.val, list);
        list.remove(list.size() - 1);
    }
}
