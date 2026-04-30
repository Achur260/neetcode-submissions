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
    public ListNode reverseList(ListNode head) {
        
        ListNode rep = head;

        if (head == null || head.next == null) {
            return head;
        }


        while(rep.next != null) {
            rep = rep.next;
        }


        ListNode currNode = head;

        while (currNode != rep) {
            ListNode nextNode = currNode.next;

            currNode.next = rep.next;
            rep.next = currNode;

            currNode = nextNode;
        }



        return rep;






    }
}
