# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.n1 = None
        self.n2 = None
        self.pre = None
    
    def findn(self, root):
        if root is None:
            return
        self.findn(root.left)
        if self.pre is None:
            self.pre = root
        else:
            if self.n1 is None and root.val < self.pre.val:
                self.n1 = self.pre
            if self.n1 is not None and root.val < self.pre.val:
                self.n2 = root
            else:
                self.pre = root
                
        
        self.findn(root.right)
        
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        self.findn(root)
        if self.n1 is not None and self.n2 is not None:
            self.n1.val, self.n2.val = self.n2.val, self.n1.val