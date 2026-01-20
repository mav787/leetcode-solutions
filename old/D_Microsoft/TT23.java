package old.D_Microsoft;
import java.util.*;
public class TT23 {
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        if(lists == null || lists.length == 0) return null;
        Queue<ListNode> heap = new PriorityQueue<>(/*lists.length, */ (n1, n2) -> n1.val - n2.val);
        for(ListNode head : lists){
            if(head != null){
                heap.offer(head);
            }
        }
        
        ListNode curr = dummy;
        while(!heap.isEmpty()){
            curr.next = heap.poll();
            curr = curr.next;
            if(curr.next != null){
                heap.offer(curr.next);
            }
        }
        return dummy.next;
    }
}
