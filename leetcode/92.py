# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        if m == n:
            return head

        dummyNode = ListNode(0)
        dummyNode.next = head
        pre = dummyNode

        for i in range(m - 1):
            pre = pre.next
        
        # reverse the [m, n] nodes
        reverse = None
        cur = pre.next
        for i in range(n - m + 1):
            next = cur.next
            cur.next = reverse
            reverse = cur
            cur = next

        # key!    
        pre.next.next = cur
        pre.next = reverse

        return dummyNode.next


    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return None
        
        first = head
        
        if not head.next:
            first.next = None
            return first
            
        second = head.next
        
        if not head.next.next:
            second.next = first
            first.next = None
            return second
            
        third = head.next.next
        second.next = first
        first.next = None
        
        while third.next:
            first = second
            second = third
            third = third.next
            second.next = first
            
        
        third.next = second
        return third    