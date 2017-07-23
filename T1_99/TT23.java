package T1_99;
import java.util.*;

public class TT23 {
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        Queue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
                public int compare(ListNode a, ListNode b){
                    return a.val - b.val;
                }
            });
        for(ListNode node : lists){
            if(node != null)
                heap.offer(node);
        }
        
        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            curr.next = node;
            curr = curr.next;
            if(node.next != null)
                heap.offer(node.next);
        }
        return dummy.next;
    }
}
