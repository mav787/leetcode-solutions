package Z2025.T100_999;

public class T234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, pre = slow;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;
        slow = reverse(slow);

        boolean res = isEqual(slow, head);

        slow = reverse(slow);
        pre.next = slow;

        return res;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null, curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

    private boolean isEqual(ListNode slow, ListNode head){
        if(slow == null && head == null){
            return true;
        }
        if(slow == null || head == null){
            // handle odd counts
            if(slow != null && slow.next == null){
                return true;
            }
            return false;
        }

        return slow.val == head.val && isEqual(slow.next, head.next);
    }
}
