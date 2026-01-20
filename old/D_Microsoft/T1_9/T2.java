package old.D_Microsoft.T1_9;

public class T2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummy = new ListNode(0);

        ListNode p = l1, q = l2, curr = dummy;

        int carry = 0, digit = 0;

        while(p != null || q != null){
            int pval = p == null ? 0 : p.val;
            int qval = q == null ? 0 : q.val;

            int sum = pval + qval + carry;

            digit = sum % 10;
            carry = sum / 10;

            curr.next = new ListNode(digit);
            curr = curr.next;

            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }

        if(carry != 0){
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
