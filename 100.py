# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """
        d=dict()
        d['flag'] = 0
        
        def visit(node1, node2):
            if d['flag'] == 1:
                return
            if node1 == None and node2 == None:
                return
            if node1 == None and node2 != None:
                d['flag'] = 1
                return
            if node1 != None and node2 == None:
                d['flag'] = 1
                return
            if node1.val != node2.val:
                d['flag'] = 1
                return
            visit(node1.left, node2.left)
            visit(node1.right, node2.right)
            return
        
        visit(p, q)
        return False if d['flag'] == 1 else True