# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        now = head
        
        while now:
            if now.next and now.next.val == now.val:
                if now.next.next:
                    now.next = now.next.next
                else:
                    now.next = None
            else:
                now = now.next
            
        return head