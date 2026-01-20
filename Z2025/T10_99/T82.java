package Z2025.T10_99;

public class T82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        if(head == null){
            return null;
        }

        ListNode pre = dummy, curr = head;
        while(curr != null){
            ListNode next = curr.next;
            if(next != null && next.val == curr.val){
                while(next != null && next.val == curr.val){
                    next = next.next;
                }
                pre.next = deleteDuplicates(next);
                return dummy.next;
            }
            else{
                pre = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
