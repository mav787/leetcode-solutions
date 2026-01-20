package old.T200_299;

public class T206Recur {
	public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
