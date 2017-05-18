# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):

    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        num1 = 0
        count1 = 1
        while l1:
            num1 += l1.val * count1
            count1 *= 10
            l1 = l1.next
        num2 = 0
        count2 = 1
        while l2:
            num2 += l2.val * count2
            count2 *= 10
            l2 = l2.next
        ans = num1 + num2
        l3 = ListNode(ans % 10)
        ans //= 10
        if not ans:
            return l3
        l3.next = ListNode(0)
        node = l3.next
        while 1:
            x = ans % 10
            ans //= 10
            node.val = x
            if not ans:
                break
            node.next = ListNode(0)
            node = node.next
        return l3
