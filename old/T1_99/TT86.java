package old.T1_99;

public class TT86 {
	public ListNode partition(ListNode head, int x) {
        if(head == null)
           return null;
       ListNode dummyless = new ListNode(0), dummygreater = new ListNode(0);
       ListNode currless = dummyless, currgreater = dummygreater;
       while(head != null){
           if(head.val < x){
               currless.next = head;
               currless = currless.next;
           }
           else{
               currgreater.next = head;
               currgreater = currgreater.next;
           }
           head = head.next;
       }
       currgreater.next = null;		// important !
       currless.next = dummygreater.next;
       return dummyless.next;
   }
}
