package T200_299;

public class T206 {
	public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode pre = null, curr = head, next = head.next;
        while(curr != null){
            curr.next = pre;
            pre = curr;
            curr = next;
            if(next != null)
                next = next.next;
        }
        return pre;
    }
}
