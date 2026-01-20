package old.T1_99;

public class TT61 {
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k < 0)
            return head;
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        
        k = k % len;
        if(k == 0)  
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for(int i = 0; i < len - k - 1; i++){
            head = head.next;
        }
        ListNode newHead = head.next;
        curr = newHead;
        head.next = null;
        while(curr.next != null)
            curr = curr.next;
        curr.next = dummy.next;
        return newHead;
    }
}
