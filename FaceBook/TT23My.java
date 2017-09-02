package FaceBook;
import java.util.*;
public class TT23My {
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        Queue<ListNode> heap = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null)
                heap.offer(lists[i]);
        }
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
