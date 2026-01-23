package Z2025.T100_999;

public class T141 {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}
