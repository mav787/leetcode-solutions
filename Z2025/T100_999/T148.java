package Z2025.T100_999;

public class T148 {
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }

        int len = getLength(head);
        return helper(head, len);
    }

    private ListNode helper(ListNode head, int len){
        if(len <= 1){
            return head;
        }

        ListNode pre = head, curr = head;
        for(int i = 0; i < len / 2; i++){
            pre = curr;
            curr = curr.next;
        }

        pre.next = null;

        ListNode first = helper(head, len / 2);
        ListNode second = helper(curr, len - len / 2);
        return merge(first, second);
    }

    private ListNode merge(ListNode p, ListNode q){
        ListNode dummy = new ListNode(0), curr = dummy;
        while(p != null || q != null){
            if(p == null){
                curr.next = q;
                q = q.next;
            }
            else if(q == null){
                curr.next = p;
                p = p.next;
            }
            else{
                if(p.val < q.val){
                    curr.next = p;
                    p = p.next;
                }
                else{
                    curr.next = q;
                    q = q.next;
                }
            }
            curr = curr.next;
        }

        return dummy.next;
    }


    private int getLength(ListNode head){
        if(head == null){
            return 0;
        }

        return 1 + getLength(head.next);
    }
}
