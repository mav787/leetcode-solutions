package old.T200_299;

public class T206 {
	public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
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
