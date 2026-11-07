package Z2025.T100_999;

public class T328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);

        ListNode oddCurr = oddDummy, evenCurr = evenDummy;

        boolean isOdd = true;
        while(head != null){
            if(isOdd){
                oddCurr.next = head;
                oddCurr = oddCurr.next;
            }
            else{
                evenCurr.next = head;
                evenCurr = evenCurr.next;
            }

            head = head.next;
            isOdd = !isOdd;
        }

        evenCurr.next = null;
        oddCurr.next = evenDummy.next;
        return oddDummy.next;
    }
}
