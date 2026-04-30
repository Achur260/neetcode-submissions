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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode last = head;
        ListNode rem = head;
        ListNode prev = null;
        for (int i = 0; i < n && last != null; i++) {
            last = last.next;
        }

        while(last != null) {
            prev=rem;
            rem = rem.next;
            last = last.next;
        }

        if (rem == head) {
            head = head.next;
            return head;
        }

        prev.next = rem.next;

        return head;






    }
}
