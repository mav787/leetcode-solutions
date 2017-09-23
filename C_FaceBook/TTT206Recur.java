package C_FaceBook;

public class TTT206Recur {
	public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
}
