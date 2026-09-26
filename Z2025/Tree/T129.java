package Z2025.Tree;

import java.util.*;

public class T129 {

    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, 0, list);
        int res = 0;
        for(int i : list){
            res += i;
        }

        return res;
    }

    private void helper(TreeNode root, int num, List<Integer> list){
        if(root == null){
            return;
        }

        num = num * 10 + root.val;
        if(root.left == null && root.right == null){
            list.add(num);
            return;
        }

        helper(root.left, num, list);
        helper(root.right, num, list);
    }
}
