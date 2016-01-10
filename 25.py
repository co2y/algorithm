# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):

    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        cur = head
        cnt = 0
        while cur and cnt != k:
            cur = cur.next
            cnt += 1
        if cnt == k:
            cur = self.reverseKGroup(cur, k)
            cnt -= 1
            while cnt >= 0:
                cnt -= 1
                temp = head.next
                head.next = cur
                cur = head
                head = temp
            head = cur

        return head
