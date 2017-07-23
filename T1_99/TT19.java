package T1_99;

public class TT19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for(int i = 0; i < n; i++){
            fast = fast.next;
            if(fast == null)
                return dummy.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
