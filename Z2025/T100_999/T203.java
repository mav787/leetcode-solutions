package Z2025.T100_999;

public class T203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;

        while(head != null){
            if(head.val == val){
                pre.next = head.next;
            }
            else{
                pre = head;
            }

            head = head.next;
        }

        return dummy.next;
    }
}
