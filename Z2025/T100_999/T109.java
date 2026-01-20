package Z2025.T100_999;
import java.util.*;

public class T109 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = linked2Array(head);
        return helper(list, 0, list.size() - 1);
    }

    private List<Integer> linked2Array(ListNode head){
        List<Integer> res = new ArrayList<>();
        while(head != null){
            res.add(head.val);
            head = head.next;
        }
        return res;
    }

    private TreeNode helper(List<Integer> list, int left, int right){
        if(left > right){
            return null;
        }
        if(left == right){
            return new TreeNode(list.get(left));
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper(list, left, mid - 1);
        root.right = helper(list, mid + 1, right);
        return root;
    }
}
