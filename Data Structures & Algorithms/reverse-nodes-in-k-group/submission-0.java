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
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode temp = head;

        
        int i = 0;
        for (; i < k - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (i < k - 1) {
            return head;
        }

        temp.next = reverseKGroup(temp.next, k);

        ListNode ntemp = head;

        while (ntemp != temp) {
            ListNode nNext = ntemp.next;
            ntemp.next = temp.next;
            temp.next = ntemp;
            ntemp = nNext;
        }



        return ntemp;
        
    }

}
