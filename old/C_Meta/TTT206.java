package old.C_Meta;

public class TTT206 {
	public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
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
