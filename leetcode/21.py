# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):

    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if not l1 or not l2:
            return l1 if l1 else l2
        if l1.val < l2.val:
            r = ListNode(l1.val)
            l1 = l1.next
        else:
            r = ListNode(l2.val)
            l2 = l2.next
        head = r
        while True:
            if l1 == None and l2 == None:
                break
            if l1 == None:
                r.next = l2
                break
            if l2 == None:
                r.next = l1
                break
            if l1.val < l2.val:
                temp = ListNode(l1.val)
                r.next = temp
                r = temp
                l1 = l1.next
            else:
                temp = ListNode(l2.val)
                r.next = temp
                r = temp
                l2 = l2.next
        return head
