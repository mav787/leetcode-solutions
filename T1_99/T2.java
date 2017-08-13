package T1_99;

public class T2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode curr1 = l1, curr2 = l2;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(curr1 != null || curr2 != null){
            int val1 = curr1 == null ? 0 : curr1.val;
            int val2 = curr2 == null ? 0 : curr2.val;
            int sum = val1 + val2 + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            if(curr1 != null) curr1 = curr1.next;
            if(curr2 != null) curr2 = curr2.next;
        }
        
        if(carry != 0){
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
 
