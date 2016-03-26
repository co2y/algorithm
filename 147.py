# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def insertionSortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return head
        else:
            now = head.val
            head = head.next
        rhead = ListNode(0)
        rhead.next = ListNode(now)
        while head:
            now = head.val
            head = head.next
            temphead = rhead
            while 1:
                if not temphead.next:
                    temphead.next = ListNode(now)
                    break
                elif now < temphead.next.val:
                    tempNode = ListNode(now)
                    tempNode.next = temphead.next
                    temphead.next = tempNode
                    break
                else:
                    temphead = temphead.next
                    
        return rhead.next