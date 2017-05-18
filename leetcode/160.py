# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        # p, q = headA, headB;
        # while p != q:
        #     p = p.next if p else headB;
        #     q = q.next if q else headA;
        # return p;
        # if headA == None or headB == None:
        #     return None
        
        pa = headA
        pb = headB
        
        while pa != pb:
        #while pa != None and pb != None and pa != pb:
            pa = pa.next if pa else headB
            pb = pb.next if pb else headA
            
            # if pa == None:
            #     pa = headB
                
            # if pb == None:
            #     pb = headA
                
        return pa