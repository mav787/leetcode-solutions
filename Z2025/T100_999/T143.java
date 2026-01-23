package Z2025.T100_999;

public class T143 {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow.next;
        slow.next = null;

        fast = reverse(fast);

        slow = head;
        ListNode l1 = slow, l2 = fast;

        while(l1 != null && l2 != null){
            ListNode l1next = l1.next;
            l1.next = l2;

            ListNode l2next = l2.next;
            l2.next = l1next;

            l1 = l1next;
            l2 = l2next;
        }
    }

    private ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }

        ListNode pre = null, curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }
}
