package Z2025.T100_999;

public class T328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);

        if(head == null){
            return head;
        }

        boolean isOdd = true;
        ListNode currOdd = oddDummy, currEven = evenDummy;
        ListNode curr = head;
        while(curr != null){
            if(isOdd){
                currOdd.next = curr;
                currOdd = curr;
            }
            else{
                currEven.next = curr;
                currEven = curr;
            }
            curr = curr.next;
            isOdd = !isOdd;
        }

        currOdd.next = evenDummy.next;
        currEven.next = null;
        return oddDummy.next;
    }
}
