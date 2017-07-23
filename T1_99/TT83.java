package T1_99;

public class TT83 {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head;
        while(fast.next != null){
            while(fast.next != null && fast.val == fast.next.val){
                fast = fast.next;
            }
            if(fast.next == null){
                slow.next = null;
                return head;
            }
            else{
                fast = fast.next;
                slow.next = fast;
                slow = slow.next;
            }
        }
        return head;
    }
}
