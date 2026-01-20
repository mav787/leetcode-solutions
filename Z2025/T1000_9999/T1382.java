package Z2025.T1000_9999;
import java.util.*;

public class T1382 {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        tree2List(root, list);
        return list2BST(list, 0, list.size() - 1);
    }

    private void tree2List(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        tree2List(root.left, list);
        list.add(root.val);
        tree2List(root.right, list);
    }

    private TreeNode list2BST(List<Integer> list, int left, int right){
        if(left > right){
            return null;
        }

        if(left == right){
            return new TreeNode(list.get(left));
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = list2BST(list, left, mid - 1);
        root.right = list2BST(list, mid + 1, right);
        return root;
    }
}
