package old.T1_99;

public class T2my {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return null;
        }
        
        ListNode res = new ListNode((l1.val + l2.val) % 10);
        int carry = (l1.val + l2.val) / 10;
        
        ListNode left = l1, right = l2, curr = res;
        
        while(left.next != null || right.next != null){
            int leftval = 0, rightval = 0;
            if(left.next != null){
                left = left.next;
                leftval = left.val;
            }
            
            if(right.next != null){
                right = right.next;
                rightval = right.val;
            }
            
            int value = leftval + rightval + carry;
            curr.next = new ListNode(value % 10);
            carry = value / 10;
            curr = curr.next;
        }
        
        if(carry != 0){
            curr.next = new ListNode(1);
        }
        
        return res;
    }
}
