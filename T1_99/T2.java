package T1_99;

public class T2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null)
            return null;
        if(l1 == null || l2 == null)
            return l1 == null? l2 : l1;
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummy;
        int carry = 0, digit = 0, sum = 0;
        while(p != null || q != null){
            int pval = p == null ? 0:p.val;
            int qval = q == null ? 0:q.val;
            
            sum = pval + qval + carry;
            digit = sum % 10;
            carry = sum / 10;
            
            curr.next = new ListNode(digit);
            curr = curr.next;
            p = p == null? null:p.next;
            q = q == null? null:q.next;
            
        }
        if (carry != 0){
            curr.next = new ListNode(carry);
        }
        
        return dummy.next;
        
    }
}
 
