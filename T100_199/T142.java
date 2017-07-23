package T100_199;

public class T142 {
	public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head, fast = head;
        boolean cycle = false;
        ListNode collide = null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                collide = slow;
                cycle = true;
                break;
            }
        }
        
        if(cycle == false)
            return null;
        slow = collide;
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
