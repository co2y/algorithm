# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        now = dummy
        while now.next:
            if now.next.val != val:
                now = now.next
            else:
                if now.next.next is None:
                    now.next = None
                else:
                    now.next = now.next.next
            
        return dummy.next