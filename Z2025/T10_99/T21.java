package Z2025.T10_99;

public class T21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(list1 != null || list2 != null){
            if(list1 == null){
                curr.next = list2;
                list2 = list2.next;
                curr = curr.next;
            }
            else if(list2 == null){
                curr.next = list1;
                list1  = list1.next;
                curr = curr.next;
            }
            else{
                if(list1.val < list2.val){
                    curr.next = list1;
                    list1 = list1.next;
                    curr = curr.next;
                }
                else{
                    curr.next = list2;
                    list2 = list2.next;
                    curr = curr.next;
                }
            }
        }

        return dummy.next;
    }
}
