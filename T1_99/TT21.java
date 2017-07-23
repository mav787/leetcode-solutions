package T1_99;

public class TT21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummy;
        while(p != null && q != null){
            if(p.val < q.val){
                curr.next = p;
                p = p.next;
            }
            else{
                curr.next = q;
                q = q.next;
            }
            curr = curr.next;
        }
        if(p != null){
            curr.next = p;
        }
        if(q != null){
            curr.next = q;
        }
        return dummy.next;
        
    }
}
