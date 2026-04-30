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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode start = head;

        ListNode startPrev = head;

        for (int i = 2; i <= left; i++) {
            if (start == null) 
                break;
            if (i > 2) {
                startPrev = startPrev.next;
            }
            start = start.next;
        }

        ListNode end = head;
        for (int j = 2; j <= right; j++) {
            if (end == null)
                break;
            end = end.next;
        }

        ListNode tstart = start;

        if (start == end) {
            return head;
        }

        while (start != end) {
            ListNode tnext = start.next;
            start.next = end.next;
            end.next = start;

            start = tnext;
        }




        if (tstart != head)
            startPrev.next = end;


        if (tstart == head) {
            return end;
        } else  {
            return head;
        }
        
    }
}