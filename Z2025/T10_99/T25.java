package Z2025.T10_99;

public class T25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head;
        }

        // 1. check length, if less than k, return
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;

        for(int i = 0; i < k; i++){
            if(curr.next == null){
                return head;
            }

            curr = curr.next;
        }

        // now curr is the tail of this batch
        ListNode nextBatch = curr.next;
        curr.next = null;

        // 2. reverse first k
        ListNode pre = null;
        curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        // pre is the new head, head is the new tail

        // 3. recursive calls
        head.next = reverseKGroup(nextBatch, k);
        return pre;
    }
}
