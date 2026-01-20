package old.T1_99;

public class TT24my {
	public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, newfront = head.next, newbehind = head;
        while(curr != null && curr.next != null){
            if(newfront == null)
                return dummy.next;
            curr.next = newfront;
            ListNode nextcurr = newfront.next;
            newfront.next = newbehind;
            newbehind.next = nextcurr;
            curr = newbehind;
            newbehind = curr.next;
            if(newbehind == null)
                return dummy.next;
            newfront = newbehind.next;
        }
        return dummy.next;
    }
}
