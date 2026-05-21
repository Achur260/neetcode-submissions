# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        sum1 = 0
        sum2 = 0

        top = l1

        while (l1 != None):
            sum1 *= 10
            sum1 += l1.val
            l1 = l1.next
        

        top = l2

        while (l2 != None):
            sum2 *= 10
            sum2 += l2.val
            l2 = l2.next
        

        sum3 = sum1 + sum2

        l3 = None

        if (sum3 == 0):
            return ListNode(0, None)

        while (sum3 > 0): 
            l4 = ListNode(sum3%10, l3)
            l3 = l4
            sum3 = sum3 // 10

        return l3