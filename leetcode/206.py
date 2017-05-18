# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
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
        
s = Solution()
l = ListNode(1)
l.next = ListNode(2)
l.next.next = ListNode(3)
l.next.next.next = ListNode(4)
r = s.reverseList(l)
while r:
    print r.val
    r = r.next