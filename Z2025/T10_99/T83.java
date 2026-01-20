package Z2025.T10_99;

public class T83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode curr = head;
        if(curr.next != null){
            ListNode next = curr.next;
            while(next != null && next.val == curr.val){
                next = next.next;
            }
            curr.next = deleteDuplicates(next);
        }

        return dummy.next;
    }
}
