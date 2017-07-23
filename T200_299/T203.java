package T200_299;

public class T203 {
	public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, curr = head;
        while(curr != null){
            if(curr.val == val){
                pre.next = curr.next;
            }
            else{
                pre = pre.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
