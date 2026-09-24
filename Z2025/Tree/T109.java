package Z2025.Tree;

import java.util.*;

public class T109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // find mid
        ListNode pre = dummy, slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            pre = pre.next;
        }

        fast = slow.next;
        pre.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(fast);

        return root;
    }

}
