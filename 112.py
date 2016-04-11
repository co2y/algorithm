# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.now = 0
        self.ans = False
        
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        self.findans(root, sum)
        return self.ans
        
    def findans(self, root, sum):
        if self.ans:
            return
        
        if root == None:
            return
        self.now += root.val
        if self.now == sum and root.left is None and root.right is None:
            self.ans = True
            return
        else:
            pre = root
            root = root.left
            self.findans(root, sum)
            if root is not None:
                self.now -= root.val
            root = pre
            root = root.right
            self.findans(root, sum)
            if root is not None:
                self.now -= root.val