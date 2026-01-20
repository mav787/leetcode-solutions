package Z2025.T10_99;

public class T61 {
    public ListNode rotateRight(ListNode head, int k) {
        // base cases
        if (head == null) {
            return null;
        }


        // close the linked list into the ring
        ListNode tail = head;
        int n;
        for (n = 1; tail.next != null; n++) {
            tail = tail.next;
        }

        tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode newTail = head;
        k = k % n;
        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        // break the ring
        newTail.next = null;

        return newHead;
    }
}
