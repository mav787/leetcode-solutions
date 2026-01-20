package old.T300_499;
import java.util.*;
public class T445ii {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode res = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            res.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = res;
            res = head;
            sum /= 10;
        }
        
        return res.val == 0 ? res.next : res;
    }
}
