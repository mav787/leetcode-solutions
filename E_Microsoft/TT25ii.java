package E_Microsoft;

public class TT25ii {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode curr = head;
        for(int i = 0; i < k - 1; i++){
            curr = curr.next;
            if(curr == null) return head;
        }
        
        ListNode nextGroup = curr.next;
        reverse(head, nextGroup);
        head.next = reverseKGroup(nextGroup, k);
        return curr;
    }
    
    private void reverse(ListNode head, ListNode nextGroup){
        ListNode pre = null, curr = head;
        while(curr != nextGroup){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
    }
}