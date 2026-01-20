package Z2025.T10_99;

public class T86 {
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0), bigDummy = new ListNode(0);
        ListNode smallCurr = smallDummy, bigCurr = bigDummy;

        while(head != null){
            if(head.val < x){
                smallCurr.next = head;
                smallCurr = head;
            }
            else{
                bigCurr.next = head;
                bigCurr = head;
            }
            head = head.next;
        }

        bigCurr.next = null;
        smallCurr.next = bigDummy.next;

        return smallDummy.next;
    }
}
