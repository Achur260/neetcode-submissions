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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1,n2) -> {
            return n1.val - n2.val;
        });


        for (ListNode node : lists) {
            pq.add(node);
        }

        while (!pq.isEmpty()) {
            ListNode rem = pq.remove();
            ListNode next = rem.next;

            curr.next = rem;
            rem.next = null;
            curr = rem;

            if (next != null)
                pq.add(next);

        }




        return head.next;

    }
}
