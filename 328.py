# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return head
        if head.next:
            evenhead = head.next
        else:
            return head
        now = head
        evennow = evenhead
        while now:
            if evennow.next:
                now.next = evennow.next
                now = now.next
                if now.next:
                    evennow.next = now.next
                    evennow = evennow.next
                else:
                    evennow.next = None
                    break
            else:
                break
        now.next = evenhead
        return head
