package T200_299;

public class T203My {
	public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, next = curr.next;
        while(next != null){
            while(next != null && next.val == val){
                next = next.next;
            }
            curr.next = next;
            curr = curr.next;
            if(curr != null)
                next = curr.next;
        }
        return dummy.next;
    }
}
