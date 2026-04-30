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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(-1);

        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode currPrev = head;

        while (node1 != null && node2 != null) {

            if (node1.val < node2.val) {
                ListNode next1 = node1.next;
                
                node1.next = null;
                currPrev.next = node1;
                node1 = next1;
                currPrev = currPrev.next;

            } else {
                ListNode next2 = node2.next;
                
                node2.next = null;
                currPrev.next = node2;
                node2 = next2;
                currPrev = currPrev.next;

            }
        
        }



        while (node1 != null) {
            ListNode next1 = node1.next;
                
                node1.next = null;
                currPrev.next = node1;
                node1 = next1;
                currPrev = currPrev.next;
        }

        while (node2 != null) {
            ListNode next2 = node2.next;
                
            node2.next = null;
            currPrev.next = node2;
            node2 = next2;
            currPrev = currPrev.next;
        }
        return head.next;
        
    }
}