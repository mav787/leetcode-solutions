package Z2025.T10_99;

public class T24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode nextBatch = head.next.next;

        dummy.next = head.next;
        head.next.next = head;
        head.next = swapPairs(nextBatch);
        return dummy.next;
    }
}
