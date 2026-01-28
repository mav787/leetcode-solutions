package Z2025.T100_999;

public class T160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA), lenB = getLength(headB);
        if(lenA > lenB){
            return getIntersectionNode(headB, headA);
        }

        // now lenA <= lenB
        ListNode currA = headA, currB = headB;
        for(int i = 0; i < lenB - lenA; i++){
            currB = currB.next;
        }

        while(currA != currB && currA != null){
            currA = currA.next;
            currB = currB.next;
        }

        return currA;
    }

    private int getLength(ListNode head){
        int res = 0;
        while(head != null){
            res++;
            head = head.next;
        }
        return res;
    }
}
