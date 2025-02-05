package C_Meta;

public class TT25NonRecur {
	public ListNode reverseKGroup(ListNode head, int k) {
	    ListNode prevTail;
	    if (head == null || k <= 1)
	    	return head;
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    prevTail = dummy;
	    int nodeCount = 0;
	    while (head != null){
	    	nodeCount++;
	    	if (nodeCount % k == 0){
	    		prevTail = reverse(prevTail, head.next);
	    		head = prevTail.next;
	    	} else {
	    		head = head.next;
	    	}
	    }
	    return dummy.next;
	    
	}

	public ListNode reverse(ListNode begin, ListNode end){
		ListNode pre = begin, curr = begin.next;
		ListNode first = curr;
		
		while (curr != end){
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		
		begin.next = pre;		// at the front
		first.next = curr;		// in the end
		return first;
	}
}
