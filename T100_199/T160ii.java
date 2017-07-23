package T100_199;

public class T160ii {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lenA = 0, lenB = 0;
        ListNode currA = headA, currB = headB;
        while(currA != null){
            currA = currA.next;
            lenA++;
        }
        while(currB != null){
            currB = currB.next;
            lenB++;
        }
        
        currA = headA;
        currB = headB;
        if(lenA > lenB){
            for(int i = 0; i < lenA - lenB; i++){
                currA = currA.next;
            }
        }
        else{
            for(int i = 0; i < lenB - lenA; i++){
                currB = currB.next;
            }
        }
        
        while(currA != null && currB != null && currA != currB){
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }
}
