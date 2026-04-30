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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum1 = 0;
        int sum2 = 0;

        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        int carry = 0;

        while(t1 != null && t2 != null) {
            int val1 = t1.val;
            int val2 = t2.val;
            int sum = val1 + val2 + carry;
            if (sum>=10) {
                carry = 1;
            } else {
                carry = 0;
            }

            curr.next = new ListNode(sum % 10);
            curr=curr.next;
            t1=t1.next;
            t2=t2.next;
            
        }

        while (t1 != null) {
            int sum = t1.val + carry;
            if (sum >= 10) {
                carry =1;
            } else {
                carry = 0;
            }

            curr.next = new ListNode(sum%10);
            curr = curr.next;
            t1 = t1.next;
        }


        while (t2 != null) {
            int sum = t2.val + carry;
            if (sum >= 10) {
                carry =1;
            } else {
                carry = 0;
            }

            curr.next = new ListNode(sum%10);
            curr = curr.next;
            t2 = t2.next;
        }

        if (carry > 0)
            curr.next = new ListNode(carry);

        return head.next;

        
        
    }
}
