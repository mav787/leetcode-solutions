package T100_199;

public class T160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lenA = getLength(headA), lenB = getLength(headB);
        int diff = lenA - lenB;
        ListNode currA = headA, currB = headB;
        if(diff > 0){
            for(int i = 0; i < diff; i++){
                currA = currA.next;
            }
        }
        else{
            for(int i = 0; i < -diff; i++){
                currB = currB.next;
            }
        }
        
        while(currA != null && currB != null){
            if(currA == currB)
                return currA;
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
    
    
    private int getLength(ListNode node){
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }
}
