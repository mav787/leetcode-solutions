package Microsoft;

public class TT25 {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1)
            return head;
        ListNode curr = head;
        // base case check
        for(int i = 0; i < k - 1; i++){
            curr = curr.next;
            if(curr == null)
                return head;
        }
        
        ListNode nextGroup = curr.next;
        curr.next = null;
        ListNode res = reverse(head);
        head.next = reverseKGroup(nextGroup, k);
        return res;
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
