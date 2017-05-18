# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# 利用dummy node 可以把头结点和其他节点同等考虑，少考虑一些特殊情况
class Solution(object):

    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        p, q = dummy, dummy

        # first 'q' go n step
        for i in range(n):
            q = q.next

        # q & p
        while q.next:
            p = p.next
            q = q.next

        rec = p.next
        p.next = rec.next
        return dummy.next
