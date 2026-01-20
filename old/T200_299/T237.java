package old.T200_299;

public class T237 {
	public void deleteNode(ListNode node) {
        if(node == null || node.next == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
