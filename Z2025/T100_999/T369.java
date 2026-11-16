package Z2025.T100_999;

import java.util.*;

public class T369 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode plusOne(ListNode head) {
            // reverse
            ListNode newHead = reverse(head);

            // plus at head
            plus(newHead);

            // reverse back
            return reverse(newHead);
        }

        private void plus(ListNode head){
            if(head == null){
                return;
            }

            int sum = head.val + 1;

            head.val = sum % 10;

            int carry = sum / 10;
            ListNode curr = head;

            while(carry != 0){
                if(curr.next == null){
                    curr.next = new ListNode(0);
                }
                curr = curr.next;
                sum = curr.val + carry;
                curr.val = sum % 10;
                carry = sum / 10;
            }
        }



        private ListNode reverse(ListNode head){
            if(head == null){
                return head;
            }

            ListNode pre = null, curr = head;
            while(curr != null){
                ListNode next = curr.next;
                curr.next = pre;

                pre = curr;
                curr = next;
            }
            return pre;
        }
    }
}
