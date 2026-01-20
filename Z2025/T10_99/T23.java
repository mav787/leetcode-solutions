package Z2025.T10_99;
import java.util.*;

public class T23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        if(lists == null || lists.length == 0){
            return null;
        }

        Queue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode node : lists){
            if(node != null){
                heap.offer(node);
            }
        }

        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            curr.next = node;
            curr = curr.next;

            if(node.next != null){
                heap.offer(node.next);
            }
        }

        return dummy.next;
    }
}
