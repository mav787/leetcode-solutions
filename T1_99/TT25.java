package T1_99;

public class TT25 {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode curr = head;
        // base case check
        for(int i = 0; i < k - 1; i++){
            curr = curr.next;
            if(curr == null)
                return head;
        }
        if(k <= 1) 
            return head;
        ListNode pre = null, current = head, next = head.next;
        for(int i = 0; i < k; i++){
            current.next = pre;
            pre = current;
            current = next;
            if(current != null)
                next = current.next;
        }
        head.next = reverseKGroup(current, k);
        return pre;
        
    }
}
