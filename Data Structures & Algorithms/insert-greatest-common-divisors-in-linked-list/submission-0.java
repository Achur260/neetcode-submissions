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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;

            int currVal = curr.val;
            int nextVal = next.val;

            int gcd = euclid(curr.val, next.val);

            ListNode nNode = new ListNode(gcd);

            curr.next = nNode;
            nNode.next = next;

            curr = next;
        }


        return head;
    }



    public int euclid(int a, int b) {
        if (b == 0) {
            return a;
        }

        if (a < b) {
            return euclid (b, a);
        }

        int c = a % b;

        return euclid (b, c);

    }
}