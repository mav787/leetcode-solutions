package old.T100_199;

public class T147 {
	public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            ListNode cursor = dummy;
            while(cursor.next != null && cursor.next.val <= curr.val){
                cursor = cursor.next;
            }
            curr.next = cursor.next;
            cursor.next = curr;
            
            curr = next;
        }
        
        return dummy.next;
    }
}
