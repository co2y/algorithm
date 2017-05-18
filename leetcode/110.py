# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def depth(node):
            if node is None:
                return 0
            
            l = depth(node.left)
            if l == -1:
                return -1
            
            r = depth(node.right)
            if r == -1:
                return -1
                
            return 1+max(l,r) if abs(l-r)<=1 else -1
            
        return True if depth(root) != -1 else False