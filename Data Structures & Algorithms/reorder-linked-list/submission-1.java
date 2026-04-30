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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }



        ListNode curr = slow.next;
        ListNode last = curr;


        while (last != null && last.next != null) {
            last = last.next;
        }

        while(curr != null && curr != last) {

            ListNode next = curr.next;

            curr.next = last.next;
            last.next = curr;

            curr = next;

        }


        ListNode top = new ListNode();
        ListNode a = head;
        ListNode b = last;

        while (a!= null && b != null) {
            ListNode aNext = a.next;
            ListNode bNext = b.next;
            

            top.next = a;
            a.next = b;
            b.next = null;
            top = b;

            a = aNext;
            b = bNext;



            
        }

        if (top != null) {


            top.next = a;
            a.next = null;
            
            
        }
        System.out.println(a.val);

        // if (a != null) {
        //     System.out.println(a.val);
        //     System.out.println(a.next);
        //     a.next = null;
        //     top.next = a;}

       



        
        
    }
}
