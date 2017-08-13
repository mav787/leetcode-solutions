package T1_99;

public class TT25NonRecur {
	public ListNode reverseKGroup(ListNode head, int k) {
	    ListNode begin;
	    if (head==null || head.next ==null || k==1)
	    	return head;
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    begin = dummy;
	    int i = 0;
	    while (head != null){
	    	i++;
	    	if (i % k == 0){
	    		begin = reverse(begin, head.next);
	    		head = begin.next;
	    	} else {
	    		head = head.next;
	    	}
	    }
	    return dummy.next;
	    
	}

	public ListNode reverse(ListNode begin, ListNode end){
		ListNode curr = begin.next;
		ListNode next, first;
		ListNode prev = begin;
		first = curr;
		while (curr != end){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		begin.next = prev;
		first.next = curr;
		return first;
	}
}
