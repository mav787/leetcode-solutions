package T300_499;
import java.util.*;

public class T445 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int val1 = s1.isEmpty() ? 0 : s1.pop();
            int val2 = s2.isEmpty() ? 0 : s2.pop();
            
            int sum = val1 + val2 + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
        }
        if(carry != 0){
            curr.next = new ListNode(carry);
        }
        
        return reverse(dummy.next);
    }
    
    private ListNode reverse(ListNode curr){
        ListNode pre = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
