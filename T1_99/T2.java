package T1_99;

public class T2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int pval = l1 == null ? 0 : l1.val;
            int qval = l2 == null ? 0 : l2.val;
            int sum = pval + qval + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry != 0){
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
 
