# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.order = []
    
    def visit(self, node):
            if node is None:
                return
            
            self.visit(node.left)
            self.order.append(node.val)
            self.visit(node.right)
            
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        
        self.visit(root)
        
        l = len(self.order)
        for i in range(l-1):
            if self.order[i+1] <= self.order[i]:
                return False
                
        return True