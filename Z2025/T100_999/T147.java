package Z2025.T100_999;


public class T147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(head != null){
            ListNode next = head.next;
            // head.next = null;

            ListNode curr = dummy;
            while(curr.next != null && head.val >= curr.next.val){
                curr = curr.next;
            }

            ListNode currNext = curr.next;
            curr.next = head;
            head.next = currNext;

            head = next;
        }

        return dummy.next;
    }
}
