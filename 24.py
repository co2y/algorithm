# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):

    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head
        xx = ListNode(0)
        xx.next = head.next
        while 1:
            temp1 = head.next
            head.next = temp1.next
            temp1.next = head
            if not head.next or not head.next.next:
                break
            temp2 = head
            head = head.next
            temp2.next = head.next
        return xx.next
