package E_Microsoft;

public class TT24 {
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = head.next;
        ListNode nextGroup = newHead.next;
        newHead.next = head;
        head.next = swapPairs(nextGroup);
        return newHead;
    }
}
