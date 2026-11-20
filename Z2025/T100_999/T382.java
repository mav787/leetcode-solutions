package Z2025.T100_999;

import java.util.*;

public class T382 {
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
        List<Integer> list;
        Random random;

        public Solution(ListNode head) {
            list = new ArrayList<>();
            random = new Random();
            while(head != null){
                list.add(head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

}
