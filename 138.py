# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        dummy = RandomListNode(0)
        node = dummy
        h = head
        hashmap = dict()
        while h:
            copy = RandomListNode(h.label)
            hashmap[h] = copy
            node.next = copy
            node = node.next
            h = h.next
        
        while head:
            if head.random is None:
                hashmap[head].random = None
            else:
                hashmap[head].random = hashmap[head.random]
            head = head.next
        return dummy.next