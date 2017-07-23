package T1_99;

public class TT82 {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head, slow = dummy;
        boolean thisdup = false;
        while(fast.next != null){
            thisdup = false;
            while(fast.next != null && fast.val == fast.next.val){
                fast = fast.next;
                thisdup = true;
            }
            if(thisdup){
                fast = fast.next;
                if(fast == null){
                    slow.next = null;
                    break;
                }
                continue;
            }
            slow.next = fast;
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = fast;
        return dummy.next;
    }
}
