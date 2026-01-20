package Z2025.T10_99;

public class T92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode leftNode = dummy, rightNode = dummy;
        ListNode pre = dummy;

        for(int i = 0; i < right; i++){
            if(i < left){
                leftNode = leftNode.next;
            }
            if(i < left - 1){
                pre = pre.next;
            }

            rightNode = rightNode.next;
        }

        ListNode next = rightNode.next;
        rightNode.next = null;

        pre.next = reverse(leftNode);
        leftNode.next = next;
        return dummy.next;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null, curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
